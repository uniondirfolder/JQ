package hw.d06092021_p2.GoF.behavioral.Strategy;

public class Program {

    public static void main(String[] args) {
        Developer developer = new Developer();
        System.out.println("Schedule developer Harry\n==================");
        
        developer.setActivity(new Sleeping());
        developer.executeActivity();
        
        developer.setActivity(new EatMeals());
        developer.executeActivity();
        
        developer.setActivity(new Coding());
        developer.executeActivity();
        
        developer.setActivity(new Traning());
        developer.executeActivity();
        
        developer.setActivity(new EatMeals());
        developer.executeActivity();
        
        developer.setActivity(new Sleeping());
        developer.executeActivity();
    }
}
