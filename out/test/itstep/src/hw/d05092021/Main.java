package hw.d05092021;

import java.util.*;

public class Main {
    static Random random = new Random();
    static List<String> list = new LinkedList<>();

    public static void main(String[] args) {
        int column = 4;
        int spaces = 4;
        int randCountStr = 13;
        char ch = '1';
        setRandomListStrings(randCountStr, ch);


        System.out.println(list);
        System.out.println(String.valueOf('*').repeat(30));
        System.out.println(format(column, spaces));
    }

    public static void setRandomListStrings(int randCountStr, char ch) {
        if (randCountStr < 1) return;
        if (list.size() > 0) list.clear();
        StringBuilder sb;
        for (int i = 0, j; i < randCountStr; i++) {
            j = random.nextInt(randCountStr) + 1;
            sb = new StringBuilder();
            sb.append(String.valueOf(ch).repeat(j));
            list.add(sb.toString());
        }
    }

    public static String format(int column, int spaces) {
        if (column < 2) return null;
        int row = list.size() / column;
        row += list.size() % column;

        String[][] m = new String[row][column];
        for (int i = 0, l = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (l < list.size()) {
                    m[i][j] = list.get(l);
                } else {
                    m[i][j] = " ";
                }
                l++;
            }
        }
        list.clear();

        int tab = 0;
        for (int i = 0; i < column; i++) {
            for (int w = 0; w < row; w++) {
                if (tab < m[w][i].length()) {
                    tab = m[w][i].length();
                }
            }
            for (int w = 0; w < row; w++) {
                m[w][i] = getWithSpaces(m[w][i], tab - m[w][i].length() + spaces);
            }
            tab = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int w = 0; w < column; w++) {
                sb.append(m[i][w]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String getWithSpaces(String str, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        while (count > 0) {
            sb.append(' ');
            count--;
        }
        return sb.toString();
    }
}
