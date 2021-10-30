package com.nvv.instame.facade;

import com.nvv.instame.dto.UserDTO;
import com.nvv.instame.entity.UserApp;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public UserDTO userToUserDTO(UserApp user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstName());
        userDTO.setLastname(user.getLastName());
        userDTO.setNickname(user.getUsername());
        userDTO.setBio(user.getBio());
        return userDTO;
    }

}
