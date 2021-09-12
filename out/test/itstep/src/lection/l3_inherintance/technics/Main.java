package lection.l3_inherintance.technics;

public class Main {
    public static void main(String[] args) {
//        int test;
//        System.out.println(test);

//        int[] arr = new int[4];
//        System.out.println(Arrays.toString(arr));

        Computer computer = new Computer();
        System.out.println(computer);
        System.out.println(computer.getRam());
        System.out.println(computer.ram);
        System.out.println(computer.getModel());
        System.out.println(computer.getCpuFrequency());
        computer.overclock(100);
        System.out.println(computer.getCpuFrequency());

        Laptop laptop = new Laptop();
        System.out.println(laptop.ram);
    }
}
