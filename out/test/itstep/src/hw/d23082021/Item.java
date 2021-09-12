package hw.d23082021;



import java.util.Objects;
@Developer
public final class Item {
    private Token token;
    private double itemValue;

    public Item(Token token, double itemValue) {
        this.token = token;
        this.itemValue = itemValue;

    }

    public Token getToken() {
        return token;
    }

    public double getItemValue() {
        return itemValue;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setItemValue(double itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.getItemValue(), getItemValue()) == 0 && getToken() == item.getToken();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToken(), getItemValue());
    }

    @Override
    public String toString() {
        return "Item{" +
                "token=" + token +
                ", itemValue=" + itemValue +
                '}';
    }
}
