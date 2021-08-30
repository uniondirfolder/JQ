package com.nvv.itstep.lection.l6_interfaces_lambda.lambda;

public class Controller {

    public void start() {
        System.out.println(this);

        Worker worker = new Worker() {
            @Override
            public void work() {
                System.out.println(this);
            }
        };

        Worker lambda = () -> {
            System.out.println(this);
        };

        worker.work();
        lambda.work();

        //Worker w = System.out::println;
    }
}
