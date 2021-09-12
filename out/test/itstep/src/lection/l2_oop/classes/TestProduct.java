package lection.l2_oop.classes;

public class TestProduct {
    public static void main(String[] args) {
        Product product = new Product("Milk", 20);//ctrl + P - параметры
        product.setPrice(-30);
        System.out.println(product);
        System.out.println(product.getPrice());
        product.setPrice(33);
        System.out.println(product.getPrice());
        product.setPrice(product.getPrice() + 10);
        System.out.println(product.getPrice());
        product.addPrice(20);
        System.out.println(product.getPrice());

        //System.out.println(product.price);

    }
}
