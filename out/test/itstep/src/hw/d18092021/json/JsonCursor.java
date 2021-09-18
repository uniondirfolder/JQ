package hw.d18092021.json;

import java.util.ArrayList;
import java.util.List;

public class JsonCursor implements JsonParse {
    private String stringField;
    private List<JsonItem> list = new ArrayList<>();
    private int index;
    private boolean isError;

    public JsonCursor(String stringField) {
        this.stringField = stringField;
    }

    public List<JsonItem> getList() {
        return list;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void increment() {
        index++;
    }

    public void decrement() {
        index--;
    }

    public char getChar(int index) {
        return stringField.charAt(index);
    }

    public boolean goToPosition(char ch) {
        for (; index < stringField.length(); index++) {
            if (stringField.charAt(index) == ch) return true;
        }
        return false;
    }

    public boolean backToPosition(char ch) {
        for (; index > 0; decrement()) {
            if (stringField.charAt(index) == ch) return true;
        }
        return false;
    }

    public boolean checkFieldRule(final JsonItem jsonItem) {
        String fieldName = jsonItem.getFieldName();
        char fch = fieldName.charAt(0);
        char tmp = Character.toUpperCase(fch);
        if (fch == tmp) {
            return false;
        }
        for (int i = 0; i < fieldName.length(); i++) {
            if (!Character.isAlphabetic(fieldName.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean getCursor() {
        return index < stringField.length();
    }

    public JsonItem getWithUnclouded() {
        if (index< list.size()) {
            JsonItem ji = list.get(index);
            list.remove(index);
            return ji;
        }
        return null;
    }

    public String[] getArray(final int index_start) {
        int i = 0;
        int j = index_start;
        j++;
        while (stringField.charAt(j) != ']') {
            i++;
            j++;
        }
        i--;
        if (i <= 0) return null;
        StringBuilder sb = new StringBuilder();
        j = index_start;
        j++;
        char ch = stringField.charAt(j);
        while (ch != ']') {
            if (ch != '"') {
                sb.append(stringField.charAt(j));
            }
            j++;
            ch = stringField.charAt(j);
        }
        String[] arr = sb.toString().split(",");
        return arr;
    }

}
