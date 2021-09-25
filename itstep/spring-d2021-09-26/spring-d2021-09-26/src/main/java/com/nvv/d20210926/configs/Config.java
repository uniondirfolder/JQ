package com.nvv.d20210926.configs;



import com.nvv.d20210926.aspects.ExceptionAspect;
import com.nvv.d20210926.aspects.LoggerAspect;
import com.nvv.d20210926.aspects.SecurityAspect;
import com.nvv.d20210926.implts.Candies;
import com.nvv.d20210926.implts.PocketLeft;
import com.nvv.d20210926.implts.PocketRight;
import com.nvv.d20210926.implts.UserAop;
import com.nvv.d20210926.logger.LoggerNvv;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("com.nvv")
@PropertySource("classpath:App.properties")
@EnableAspectJAutoProxy
public class Config {
    @Bean
    @Scope("singleton")
    public LoggerNvv loggerNvvBean(){
        return new LoggerNvv();
    }
    @Bean
    @Scope("singleton")
    public LoggerAspect loggerAspectBean(){
        return new LoggerAspect();
    }

    @Bean
    @Scope("singleton")
    public ExceptionAspect exceptionAspectBean(){
        return new ExceptionAspect();
    }

    @Bean
    @Scope("singleton")
    public SecurityAspect securityAspectBean(){
        return new SecurityAspect();
    }

    @Bean
    @Scope("prototype")
    public Candies candyBean() {
        return new Candies();
    }

    @Bean
    @Scope("prototype")
    public UserAop userBean() {
        return new UserAop();
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




}
