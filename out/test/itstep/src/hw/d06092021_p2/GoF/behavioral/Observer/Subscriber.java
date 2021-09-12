package hw.d06092021_p2.GoF.behavioral.Observer;

import java.util.List;

public class Subscriber implements Observer {
    String name;
    
    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " + name + "\nwe have some changes in vacancies" + vacancies + 
                "\n=====================================================\n");
    }
}
