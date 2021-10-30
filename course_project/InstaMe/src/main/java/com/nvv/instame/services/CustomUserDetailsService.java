package com.nvv.instame.services;

import com.nvv.instame.entity.UserApp;
import com.nvv.instame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) { // on front its username
        UserApp userApp = userRepository.findUserAppByEmail(email).orElseThrow(()->new UsernameNotFoundException("Username not found with username: " + email)); // but in db its email
        return build(userApp);
    }

    public UserApp loadUserById(Long id){
        return userRepository.findUserAppById(id).orElse(null);
    }

    public static UserApp build(UserApp userApp){
        List<GrantedAuthority> authorities = userApp.getRole().stream()
                .map(role->new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
        return new UserApp(
                userApp.getId(),
                userApp.getNickName(),
                userApp.getEmail(),
                userApp.getPassword(),
                authorities);
    }
}
