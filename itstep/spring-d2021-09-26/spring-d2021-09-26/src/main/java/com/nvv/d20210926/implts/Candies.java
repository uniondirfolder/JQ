package com.nvv.d20210926.implts;

import com.nvv.d20210926.interfs.Candy;
import org.springframework.beans.factory.annotation.Value;



public class Candies /*implements Candy*/{ // если заимплементить то Exception in thread "main" org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'candyBean' is expected to be of type 'com.nvv.d20210926.implts.Candies' but was actually of type 'jdk.proxy2.$Proxy25' - походу для springA интерфейсы - "зло"
    @Value("${candies.name}")
    private String name;
    @Value("${candies.price}")
    private int price;

    public Candies() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    //@Override
    public int price() {
        return getPrice();
    }

    //@Override
    public String name() {
        return getName();
    }

    @Override
    public String toString() {
        return "Candies{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
