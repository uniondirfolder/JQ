package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:myApp.properties")
public class Config_2 {

    @Bean
    @Scope("singleton")
    public GlobalAddress globalAddress(){
        return new Address_3();
    }

    @Bean
    @Scope("prototype") // communalka
    public User_3 user_3_Bean(){
        return new User_3(globalAddress());
    }
}
