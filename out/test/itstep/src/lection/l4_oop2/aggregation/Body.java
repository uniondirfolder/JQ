package lection.l4_oop2.aggregation;

public class Body {
    private String color;
    private String type;

    public Body(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Body{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
