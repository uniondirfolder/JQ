package com.nvv.d20210926;


import com.nvv.d20210926.aspects.ExceptionAspect;
import com.nvv.d20210926.aspects.LoggerAspect;
import com.nvv.d20210926.aspects.SecurityAspect;
import com.nvv.d20210926.configs.Config;
import com.nvv.d20210926.implts.Candies;
import com.nvv.d20210926.implts.PocketLeft;
import com.nvv.d20210926.implts.PocketRight;
import com.nvv.d20210926.implts.UserAop;
import com.nvv.d20210926.logger.LoggerNvv;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        LoggerNvv loggerNvv =  context.getBean("loggerNvvBean", LoggerNvv.class);
        LoggerAspect loggerAspect = context.getBean("loggerAspectBean", LoggerAspect.class);
        ExceptionAspect exceptionAspect = context.getBean("exceptionAspectBean", ExceptionAspect.class);
        SecurityAspect securityAspect = context.getBean("securityAspectBean", SecurityAspect.class);

        PocketLeft pl = context.getBean("pocketLeftBean", PocketLeft.class);
        PocketRight pr = context.getBean("pocketRightBean", PocketRight.class);

        List<UserAop> userAopList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserAop userAop = context.getBean(UserAop.class);
            userAop.setName("user: "+i);
            userAopList.add(userAop);
        }
        List<Candies> candies = new ArrayList<>();
        String[] names = new String[]{"Lollipop", "Chocolate", "Enka"};

        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            Candies candy = context.getBean("candyBean", Candies.class);
            candy.setPrice(rnd.nextInt(50) + 1);
            candy.setName(names[rnd.nextInt(names.length)]);
            candies.add(candy);

        }
        for (int i = 0; i < candies.size(); i++) {
            UserAop userAop = userAopList.get(rnd.nextInt(userAopList.size()));
            crudForUser(userAop.getCurrentUser(), rnd.nextInt(2), rnd.nextInt(4), candies.get(i) );
        }
        context.close();


    }

    public static void crudForUser(UserAop userAop, int pocket, int crud, Candies candy){
        if(crud==0){
            if(pocket==0){userAop.getPocketLeft().create(candy);}
            else{userAop.getPocketRight().create(candy);}
        }
        else if(crud==1){
            if(pocket==0){userAop.getPocketLeft().update(candy);}
            else{userAop.getPocketRight().update(candy);}
        }
        else if(crud==2){
            if(pocket==0){userAop.getPocketLeft().read(candy);}
            else{userAop.getPocketRight().read(candy);}
        }
        else if(crud==3){
            if(pocket==0){userAop.getPocketLeft().delete(candy);}
            else{userAop.getPocketRight().delete(candy);}
        }
    }
}
