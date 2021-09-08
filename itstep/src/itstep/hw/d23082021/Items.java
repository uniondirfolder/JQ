package itstep.hw.d23082021;


import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
@Developer
public class Items implements Collection<Item>, Parse {
    private Object[] array = new Object[25];
    private int count = -1;
    private int innerSize = 25;

    public Item get(int index) {
        Item o = (Item) array[index];
        return o;
    }

    @Override
    public int size() {
        return count + 1;
    }

    @Override
    public boolean isEmpty() {
        return count == -1;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        if (!isEmpty()) {
            return new Iterator<Item>() {
                int countIt = 0;

                @Override
                public boolean hasNext() {
                    return countIt != count;
                }

                @Override
                public Item next() {
                    if (hasNext()) {
                        Item tmp = (Item) array[countIt];
                        countIt++;
                        return tmp;
                    }
                    return null;
                }
            };
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] tmp = new Object[size()];
        for (int i = 0, j = size(); i < j; i++) {
            tmp[i] = array[i];
        }
        return tmp;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a != null) {
            return a;
        }
        return null;
    }

    @Override
    public boolean add(Item item) {
        try {
            if (size() + 1 == innerSize) {
                innerSize += innerSize / 2;
                Object[] tmp = new Object[innerSize];
                for (int i = 0; i < array.length; i++) {
                    tmp[i] = array[i];
                }
                //clear();
                array = tmp;
            }
        } catch (Exception e) {
            return false;
        }
        count++;
        array[count] = item;
        return true;
    }

    public void removeByIndex(int index) {
        for (; index < size() - 1; index++) {
            array[index] = array[index + 1];
        }
        array[count] = null;
        count--;
    }

    @Override
    public boolean remove(Object o) {
        try {
            throw new ExecutionControl.NotImplementedException("This method not implement in this class");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            throw new ExecutionControl.NotImplementedException("This method not implement in this class");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        try {
            c.forEach(i -> add(i));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            if (isEmpty()) {
                return false;
            }
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = null;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            throw new ExecutionControl.NotImplementedException("This method not implement in this class");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = null;
        }
        array = null;
        innerSize = 25;
        count = -1;
        array = new Object[innerSize];
    }

    @Override
    public Items toItems(String expression) throws CustomException {
        if (expression != null) {
            if (expression.length() < 5 || isAllDigits(expression)) {
                throw new CustomException("Строка не представляет собой математическое выражение! Минимально: [n знак n2] = 2 операнда, знак операции, пробелы между элементами");
            }

            boolean mustBeWhiteSpace = false;
            boolean lastSign = false;
            Items it = new Items();
            for (int i = 0, j = expression.length() - 1; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (i == j) {
                    if (ch != ')' && !Character.isDigit(ch)) {
                        throw new CustomException("Допустимые символы - ')' , '0 ... 9'. index = " + i);
                    } else if (ch == ')') {
                        it.add(new Item(Token.RIGHT_BRACKETS, Double.MIN_VALUE));
                    } else if (!Character.isDigit(expression.charAt(i - 1)) && Character.isDigit(ch) && expression.charAt(i - 1) != ' ') {
                        throw new CustomException("Допустимые символы - '0 ... 9'. index = " + i);
                    } else {
                        String s = getNumber(i, expression);
                        it.add(new Item(Token.DIGIT, Double.parseDouble(s)));
                        i += s.length() - 1;
                        lastSign = false;
                    }
                } else if (i == 0) {
                    if (ch == '(' && expression.charAt(1) == '-' && Character.isDigit(expression.charAt(2))) {
                        it.add(new Item(Token.LEFT_BRACKETS, Double.MIN_VALUE));
                        i++;
                        i++;
                        String s = getNumber(2, expression);
                        double d = Double.parseDouble(s);
                        d *= -1;
                        it.add(new Item(Token.DIGIT, d));
                        i += s.length() - 1;
                        lastSign = false;
                    } else if (ch != '(' && !Character.isDigit(ch) && ch != '-') {
                        throw new CustomException("Допустимые символы - '(' , '0 ... 9', '-'. index = " + i);
                    } else if (ch == '(') {
                        it.add(new Item(Token.LEFT_BRACKETS, Double.MIN_VALUE));
                    } else if (Character.isDigit(ch)) {
                        String s = getNumber(i, expression);
                        it.add(new Item(Token.DIGIT, Double.parseDouble(s)));
                        i += s.length() - 1;
                        mustBeWhiteSpace = true;
                        lastSign = false;
                    } else {
                        char ch1 = expression.charAt(i + 1);
                        if (!Character.isDigit(ch1)) {
                            throw new CustomException("Допустимые символы - '0 ... 9'. index = " + i + 1);
                        }
                        i++;
                        String s = getNumber(i, expression);
                        double d = Double.parseDouble(s);
                        d *= -1;
                        it.add(new Item(Token.DIGIT, d));
                        i += s.length() - 1;
                        mustBeWhiteSpace = true;
                        lastSign = false;
                    }

                } else {
                    if (Character.isSpaceChar(ch) && !mustBeWhiteSpace) {
                        throw new CustomException("Два пробела подряд. index = " + i);
                    } else if (ch == ' ' && mustBeWhiteSpace) {
                        it.add(new Item(Token.WHITESPACE, Double.MIN_VALUE));
                        mustBeWhiteSpace = false;
                    } else if (!Character.isDigit(ch) && !mustBeWhiteSpace && ch != '(') {
                        switch (ch) {
                            case ('*'):
                                it.add(new Item(Token.MULTIPLICATION, Double.MIN_VALUE));
                                lastSign = true;
                                break;
                            case ('-'):
                                char ch1 = expression.charAt(i + 1);
                                if (Character.isDigit(ch1)) {
                                    if (!lastSign) {
                                        throw new CustomException("Ошибка выражения index " + i);
                                    }
                                    i++;
                                    String s = getNumber(i, expression);
                                    double d = Double.parseDouble(s);
                                    d *= -1;
                                    it.add(new Item(Token.DIGIT, d));
                                    i += s.length() - 1;
                                    lastSign = false;
                                } else {
                                    it.add(new Item(Token.MINUS, Double.MIN_VALUE));
                                    lastSign = true;
                                }
                                break;
                            case ('+'):
                                it.add(new Item(Token.PLUS, Double.MIN_VALUE));
                                lastSign = true;
                                break;
                            case ('/'):
                                it.add(new Item(Token.DIVIDE, Double.MIN_VALUE));
                                lastSign = true;
                                break;
                            case (')'):
                                it.add(new Item(Token.RIGHT_BRACKETS, Double.MIN_VALUE));
                                break;
                            default:
                                throw new CustomException("Ожидается символы '+,*,-,/'. получен: " + ch + " index " + i);
                        }
                        mustBeWhiteSpace = true;
                    } else if (ch == '(' && !mustBeWhiteSpace) {
                        it.add(new Item(Token.LEFT_BRACKETS, Double.MIN_VALUE));
                        mustBeWhiteSpace = false;
                    } else if (Character.isDigit(ch) && !mustBeWhiteSpace) {
                        String s = getNumber(i, expression);
                        it.add(new Item(Token.DIGIT, Double.parseDouble(s)));
                        i += s.length() - 1;
                        mustBeWhiteSpace = true;
                        lastSign = false;
                    } else if (ch == ')' && mustBeWhiteSpace) {
                        it.add(new Item(Token.RIGHT_BRACKETS, Double.MIN_VALUE));
                    } else {
                        Token[] t = Token.values();
                        StringBuilder sb = new StringBuilder();
                        for (Token token : t) {
                            sb.append(token.toString());
                        }
                        throw new CustomException("Не допустимый символ. index = " + i + ".\n используются[ " + sb.toString() + " ]");
                    }
                }
            }
            Stack<Token> stack = new Stack<>();
            for (int i = 0, j = expression.length(); i < j; i++) {
                char ch = expression.charAt(i);
                if (ch == '(') {
                    stack.push(Token.LEFT_BRACKETS);
                } else if (ch == ')') {
                    if (stack.empty()) {
                        throw new CustomException("Не закрытая скобка. index= " + i);
                    }
                    stack.pop();
                }
            }
            if (!stack.empty()) {
                throw new CustomException("Не закрытые скобки. ");
            }
            it.removeSpaces();
            if (it.isEmpty()) {
                return null;
            }
            return it;
        }
        return null;
    }

    @Override
    public Item toItem() throws CustomException {
        if (!isEmpty()) {
            Item o;
            Item oL;
            Item oR;
            boolean operation = false;
            removeBrackets();
            while (size() != 1) {
                do {
                    operation = false;
                    for (int j = 1; j < size() - 1; j++) {
                        o = (Item) array[j];
                        oL = (Item) array[j - 1];
                        oR = (Item) array[j + 1];
                        Token t = o.getToken();
                        if (t == Token.MULTIPLICATION && oL.getToken() == Token.DIGIT && oR.getToken() == Token.DIGIT) {
                            oL.setItemValue(oL.getItemValue() * oR.getItemValue());
                            operation = true;
                        } else if (t == Token.DIVIDE && oL.getToken() == Token.DIGIT && oR.getToken() == Token.DIGIT) {
                            try {
                                oL.setItemValue(oL.getItemValue() / oR.getItemValue());
                            } catch (Exception e) {
                                oL.setItemValue(0);
                            }
                            operation = true;
                        }
                        if (operation) {
                            removeByIndex(j + 1);
                            removeByIndex(j);
                            break;
                        }
                    }

                } while (operation);
                do {
                    operation = false;
                    for (int j = 1; j < size() - 1; j++) {
                        o = (Item) array[j];
                        oL = (Item) array[j - 1];
                        oR = (Item) array[j + 1];
                        Token t = o.getToken();
                        if (t == Token.PLUS && oL.getToken() == Token.DIGIT && oR.getToken() == Token.DIGIT) {
                            oL.setItemValue(oL.getItemValue() + oR.getItemValue());
                            operation = true;
                        } else if (t == Token.MINUS && oL.getToken() == Token.DIGIT && oR.getToken() == Token.DIGIT) {
                            oL.setItemValue(oL.getItemValue() - oR.getItemValue());
                            operation = true;
                        }
                        if (operation) {
                            removeByIndex(j + 1);
                            removeByIndex(j);
                            break;
                        }
                    }
                    removeBrackets();
                } while (operation);
            }

            if (size() != 1) { // foo
                throw new CustomException("Калькулятор поломался!");
            }
        }
        Item o = (Item) array[0];
        return new Item(o.getToken(), o.getItemValue());
    }

    private String getNumber(int index, String line) throws CustomException {
        StringBuilder sb = new StringBuilder();
        boolean findDot = false;
        char ch = '0';
        for (; index < line.length(); index++) {
            ch = line.charAt(index);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (ch == '.') {
                if (!findDot) {
                    sb.append(ch);
                    findDot = true;
                } else {
                    break;
                }
            } else {
                break;
            }

        }
        return sb.toString();
    }

    private boolean isAllDigits(String line) {
        try {
            Double.parseDouble(line);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void removeBrackets() {
        if (size() > 1) {
            Item o;
            Item o1;
            Item o2;

            for (int i = 0; i < size(); ) {
                o = (Item) array[i];
                o1 = (Item) array[i + 1];
                o2 = (Item) array[i + 2];
                if (o.getToken() == Token.LEFT_BRACKETS && o2.getToken() == Token.RIGHT_BRACKETS && o1.getToken() == Token.DIGIT) {
                    removeByIndex(i + 2);
                    removeByIndex(i);
                    continue;
                } else {
                    o = (Item) array[i];
                    o1 = (Item) array[i + 1];
                    if (o.getToken() == Token.LEFT_BRACKETS && o1.getToken() == Token.RIGHT_BRACKETS) {
                        removeByIndex(i + 1);
                        removeByIndex(i);
                        continue;
                    }
                }
                i++;
            }
        }
    }

    private void removeSpaces() {
        Item o;
        for (int i = 0; i < size(); ) {
            o = (Item) array[i];
            if (o.getToken() == Token.WHITESPACE) {
                removeByIndex(i);
                continue;
            }
            i++;
        }
    }
}
