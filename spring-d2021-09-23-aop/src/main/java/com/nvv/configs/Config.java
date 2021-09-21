package com.nvv.configs;


import com.nvv.aspects.Logger;
import com.nvv.implts.Candies;
import com.nvv.implts.PocketLeft;
import com.nvv.implts.PocketRight;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("com.nvv")
@PropertySource("classpath:App.properties")
@EnableAspectJAutoProxy
public class Config {

    @Bean
    @Scope("prototype")
    public Candies candyBean() {
        return new Candies();
    }

    @Bean
    @Scope("singleton")
    public PocketLeft pocketLeftBean() {
        return new PocketLeft();
    }

    @Bean
    @Scope("singleton")
    public PocketRight pocketRightBean() {
        return new PocketRight();
    }

    @Bean
    @Scope("singleton")
    public Logger loggerBean(){
        return new Logger();
    }
}
