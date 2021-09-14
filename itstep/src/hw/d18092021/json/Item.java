package hw.d18092021.json;

import java.io.Serializable;
import java.util.Objects;

public final class Item implements Serializable {
    private String fieldName;
    private String value;

    public Item(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public Item(Item that) {
        this.fieldName = that.fieldName;
        this.value = that.value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return fieldName.equals(item.fieldName) && value.equals(item.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, value);
    }
}
