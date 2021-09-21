package com.nvv;

import com.nvv.aspects.Logger;
import com.nvv.configs.Config;
import com.nvv.implts.Candies;
import com.nvv.implts.PocketLeft;
import com.nvv.implts.PocketRight;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Logger log = context.getBean("loggerBean",Logger.class);
        Candies candy1 = context.getBean( "candyBean",Candies.class);
        Candies candy2 = context.getBean( "candyBean",Candies.class);

        PocketLeft pl = context.getBean("pocketLeftBean", PocketLeft.class);
        PocketRight pr = context.getBean("pocketRightBean", PocketRight.class);

        pl.create(candy1); pr.create(candy2);
        candy1.setName("Win"); candy2.setName("Bin");
        pl.update(candy1); pr.update(candy2);
        pl.read(candy1); pr.read(candy2);
        pl.delete(candy1); pl.create(candy2);

        System.out.println(candy1.getName());
        System.out.println(candy2.getName());

        context.close();
    }
}
