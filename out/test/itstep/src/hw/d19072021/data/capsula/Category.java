package hw.d19072021.data.capsula;

import java.nio.charset.StandardCharsets;

@Developer
public final class Category {

    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isUniqueName(Category left, Category right) {
        if (left.name.length() == right.name.length()) {
            byte[] l = left.name.getBytes(StandardCharsets.UTF_8);
            byte[] r = right.name.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < l.length; i++) {
                if (l[i] != r[i]) return true;
            }
            return false;
        }
        return true;
    }

}
