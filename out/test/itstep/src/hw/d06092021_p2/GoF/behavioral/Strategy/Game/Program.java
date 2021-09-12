package hw.d06092021_p2.GoF.behavioral.Strategy.Game;

public class Program {

    public static void main(String[] args) {
        Character queen = new Queen("Anna II");
        Character king = new King("Ludovic I", new AxeBehavior());
        
        System.out.println("======================\n" + queen.toString() + "\n======================");

        queen.fight();
        queen.setWeapon(new KnifeBehavior());
        queen.performWeapon();
        queen.fight();
        
        System.out.println("======================\n" + king.toString() + "\n======================");

        king.fight();
        king.setWeapon(new KnifeBehavior());
        king.performWeapon();
        king.fight();
    }
}
