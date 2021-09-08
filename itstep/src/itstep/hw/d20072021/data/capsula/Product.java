package itstep.hw.d20072021.data.capsula;

import java.nio.charset.StandardCharsets;

@Developer
public  class Product {
    private String name;
    private float price;
    private Category category;

    public Product(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isEqual(Product left, Product right){
        if(left.equals(right))return true;
        if(left.getPrice() != right.getPrice())return false;
        if(!Category.isUniqueName(left.getCategory(), right.getCategory()))return false;
        if(!isUniqueName(left.getName(), left.getName()))return false;
        return  true;
    }

    private boolean isUniqueName(String left, String right) {
        if (left.length() == right.length()) {
            byte[] l = left.getBytes(StandardCharsets.UTF_8);
            byte[] r = right.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < l.length; i++) {
                if (l[i] != r[i]) return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name +" "+price+" $ " + category.getName() + " | ";
    }
}
