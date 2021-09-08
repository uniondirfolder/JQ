package itstep.hw.d20072021.data.capsula;

@Developer
public class  ProductUnit extends Product {
    private String description;
    private int id =-1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductUnit(String name, float price, String description, Category category) {
        super(name, price, category);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ProductUnit Builder(String name, float price, String description ,String categoryName){
        return new ProductUnit(name,price, description ,new Category(categoryName));
    }

    @Override
    public String toString() {
        return super.getName() +" "+super.getPrice()+" $ " + super.getCategory().getName() + " | " + description;
    }
}
