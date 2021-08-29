package com.nvv.itstep.hw.d04092021;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;
    private String var1;
    private String var2;
    private String var3;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public Question(String question, String answer, String var1, String var2, String var3) {
        this.question = question;
        this.answer = answer;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return question.equals(question1.question) && answer.equals(question1.answer) && var1.equals(question1.var1) && var2.equals(question1.var2) && var3.equals(question1.var3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, var1, var2, var3);
    }
}
