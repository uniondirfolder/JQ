package com.nvv.itstep.hw.d04092021;

import java.util.Scanner;

@Developer
public class GameView {
    Scanner scanner = new Scanner(System.in);

    public String[] question(Question question) {
        System.out.println("Вопрос : " + question.getQuestion() + "?");
        int count = 1;
        String[] q = Question.getVariants(question);
        for (String o : q) {
            System.out.println(count + ". " + o);
            count++;
        }
        return q;
    }
    public void other(String string){
        System.out.println(string);
    }
    public String answer(){
        return scanner.nextLine();
    }
}
