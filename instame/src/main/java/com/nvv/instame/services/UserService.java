package com.nvv.instame.services;


import com.nvv.instame.entity.ERole;
import com.nvv.instame.entity.UserApp;
import com.nvv.instame.exceptions.UserAppExistException;
import com.nvv.instame.payload.response.SignupRequest;
import com.nvv.instame.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserApp createUserApp(SignupRequest userIn) {
        UserApp userApp = new UserApp();
        userApp.setEmail(userIn.getEmail());
        userApp.setNickName(userIn.getNickname());
        userApp.setFirstName(userIn.getFirstname());
        userApp.setLastName(userIn.getLastname());
        userApp.setPassword(passwordEncoder.encode(userIn.getPassword()));
        userApp.getRole().add(ERole.ROLE_USER);

        try {
            LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(userApp);
        } catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserAppExistException("The user "+userApp.getNickName() + " already exist. Please check credentials");
        }
    }
}
