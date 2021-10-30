package com.nvv.instame.web;


import com.nvv.instame.entity.ImageApp;
import com.nvv.instame.payload.response.MessageResponse;
import com.nvv.instame.services.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("api/image")
@CrossOrigin
public class ImageUploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadImageToUser(@RequestParam("file") MultipartFile file,
                                                             Principal principal) throws IOException {

        imageUploadService.uploadImageToUser(file, principal);
        return ResponseEntity.ok(new MessageResponse("Image Uploaded Successfully"));
    }

    @PostMapping("/{postId}/upload")
    public ResponseEntity<MessageResponse> uploadImageToPost(@PathVariable("postId") String postId,
                                                             @RequestParam("file") MultipartFile file,
                                                             Principal principal) throws IOException {
        imageUploadService.uploadImageToPost(file, principal, Long.parseLong(postId));
        return ResponseEntity.ok(new MessageResponse("Image Uploaded Successfully"));
    }

    @GetMapping("/profileImage")
    public ResponseEntity<ImageApp> getImageForUser(Principal principal) {
        ImageApp imageToUser = imageUploadService.getImageToUser(principal);
        return new ResponseEntity<>(imageToUser, HttpStatus.OK);
    }

    @GetMapping("/{postId}/image")
    public ResponseEntity<ImageApp> getImageToPost(@PathVariable("postId") String postId) {
        ImageApp imageToPost = imageUploadService.getImageToPost(Long.parseLong(postId));
        return new ResponseEntity<>(imageToPost, HttpStatus.OK);
    }

}
