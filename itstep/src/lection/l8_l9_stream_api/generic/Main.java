package lection.l8_l9_stream_api.generic;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(3);
//        ArrayList<String> arrayList1 = new ArrayList<>();
//        arrayList1.add("one");

        Passport<String> passport = new Passport<>("abc123");
        int number = 1234;
        Passport<Integer> passport1 = new Passport<>(number);
        System.out.println(passport1.getNumber() + 1);
        Passport<Integer> passport2 = new Passport<>(1111);


    }
}
