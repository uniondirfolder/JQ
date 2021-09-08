package hw.d20072021.arch.store;


import hw.d20072021.arch.shop.Basket;
import hw.d20072021.arch.shop.Customer;
import hw.d20072021.arch.shop.History;
import hw.d20072021.data.capsula.Developer;
import hw.d20072021.data.capsula.ProductUnit;

@Developer
public final class Buyer extends History implements InterfaceBuyer {
    private Basket basket;
    private Customer customer;
    private int id =-1;

    public Buyer(Basket basket, Customer customer, String firstSnapshot) {
        super(firstSnapshot);
        this.basket = basket;
        this.customer = customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Basket getBasket() {
        return basket;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void basketAdd(ProductUnit product) {
        // ToDo
       basket.basketAddGoods(product);
    }

    @Override
    public void basketRemoveGoods(int position) {
        // ToDo
    }

    @Override
    public void basketClear() {
        // ToDo
    }

    public static Buyer Builder(String name, int age, String firstSnapshot){
        Customer customer = new Customer(null, name, age);
        Basket basket = new Basket(customer);
        customer.setBasket(basket);
        Buyer buyer = new Buyer(basket,customer,firstSnapshot);
        return buyer;
    }
}
