package lection.l7_cf.home;

public interface MyList {
    User get(int index);
    User getFirst();
    User getLast();
    void setFirst(User user);
    void setLast(User user);
    void set(int index, User user);
    void removeAt(int index);
    int getSize();
}
