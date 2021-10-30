package com.nvv.instame.payload.request;

import com.nvv.instame.annotations.PasswordMatches;
import com.nvv.instame.annotations.ValidEmail;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignupRequest {
    @Email(message = "It should have email format")
    @NotBlank(message = "User email is required")
    @ValidEmail
    private String email;

    @NotEmpty(message = "Please enter your nick")
    private String nickname;

    @NotEmpty(message = "Please enter your firstname")
    private String firstname;

    @NotEmpty(message = "Please enter your lastname")
    private String lastname;

    @NotEmpty(message = "Password is required")
    @Size(min = 8)
    private String password;
    private String confirmPassword;


}
