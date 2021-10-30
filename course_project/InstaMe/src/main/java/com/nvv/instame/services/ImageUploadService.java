package com.nvv.instame.services;

import com.nvv.instame.entity.ImageApp;
import com.nvv.instame.entity.Post;
import com.nvv.instame.entity.UserApp;
import com.nvv.instame.exceptions.ImageNotFoundException;
import com.nvv.instame.repository.ImageRepository;
import com.nvv.instame.repository.PostRepository;
import com.nvv.instame.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageUploadService {
    public static final Logger LOG = LoggerFactory.getLogger(ImageUploadService.class);

    private ImageRepository imageRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public ImageUploadService(ImageRepository imageRepository, UserRepository userRepository, PostRepository postRepository) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public ImageApp uploadImageToUser(MultipartFile file, Principal principal) throws IOException {
        UserApp user = getUserByPrincipal(principal);
        LOG.info("Uploading image profile to User {}", user.getUsername());

        ImageApp userProfileImage = imageRepository.findByUserId(user.getId()).orElse(null);
        if (!ObjectUtils.isEmpty(userProfileImage)) {
            imageRepository.delete(userProfileImage);
        }

        ImageApp imageApp = new ImageApp();
        imageApp.setUserId(user.getId());
        imageApp.setImageBytes(compressBytes(file.getBytes()));
        imageApp.setName(file.getOriginalFilename());
        return imageRepository.save(imageApp);
    }

    public ImageApp uploadImageToPost(MultipartFile file, Principal principal, Long postId) throws IOException {
        UserApp user = getUserByPrincipal(principal);
        Post post = user.getPostList()
                .stream()
                .filter(p -> p.getId().equals(postId))
                .collect(toSinglePostCollector());

        ImageApp imageApp = new ImageApp();
        imageApp.setPostId(post.getId());
        imageApp.setImageBytes(file.getBytes());
        imageApp.setImageBytes(compressBytes(file.getBytes()));
        imageApp.setName(file.getOriginalFilename());
        LOG.info("Uploading image to Post {}", post.getId());

        return imageRepository.save(imageApp);
    }

    public ImageApp getImageToUser(Principal principal) {
        UserApp user = getUserByPrincipal(principal);

        ImageApp imageApp = imageRepository.findByUserId(user.getId()).orElse(null);
        if (!ObjectUtils.isEmpty(imageApp)) {
            imageApp.setImageBytes(decompressBytes(imageApp.getImageBytes()));
        }

        return imageApp;
    }

    public ImageApp getImageToPost(Long postId) {
        ImageApp imageApp = imageRepository.findByPostId(postId)
                .orElseThrow(() -> new ImageNotFoundException("Cannot find image to Post: " + postId));
        if (!ObjectUtils.isEmpty(imageApp)) {
            imageApp.setImageBytes(decompressBytes(imageApp.getImageBytes()));
        }

        return imageApp;
    }

    private byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            LOG.error("Cannot compress Bytes");
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    private static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException e) {
            LOG.error("Cannot decompress Bytes");
        }
        return outputStream.toByteArray();
    }

    private UserApp getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserAppByNickName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));

    }

    private <T> Collector<T, ?, T> toSinglePostCollector() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}
