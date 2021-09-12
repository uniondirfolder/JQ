package lection.l2_oop.prictices;

public class Main {
    public static void main(String[] args) {
        ArrayInt arrayInt = new ArrayInt();
        //arrayInt.size = 10;
        System.out.println(arrayInt.getSize());
        arrayInt.add(7);
        arrayInt.add(7);
        arrayInt.add(7);
        System.out.println(arrayInt.getSize());
    }
}
