package lection.l7_cf.home;

public class ArrayUser implements MyList {
    private User[] users;
    private int size;

    public ArrayUser() {
        users = new User[0];
    }

    public ArrayUser(User...users) {
        this.users = new User[users.length];
        for (int i = 0; i < this.users.length; i++) {
            this.users[i] = users[i];
        }
    }

    @Override
    public User get(int index) {
        return users[index];
    }

    @Override
    public User getFirst() {
        return users[0];
    }

    @Override
    public User getLast() {
        return users[users.length - 1];
    }

    @Override
    public void setFirst(User user) {
        User[] temp = new User[this.users.length + 1];
        for (int i = 1, j = 0; i < temp.length; i++, j++) {
            temp[i] = users[j];
        }
        temp[0] = user;
        users = temp;
    }

    @Override
    public void setLast(User user) {
        User[] temp = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            temp[i] = users[i];
        }
        temp[users.length] = user;
        users = temp;
    }

    @Override
    public void set(int index, User user) {
        if (index >= 0 && index <= (users.length - 1)) {
            User[] temp = new User[users.length];
            for (int i = 0; i < index; i++) {
                temp[i] = users[i];
            }
            temp[index] = user;
            for (int i = index + 1; i < users.length; i++) {
                temp[i] = users[i];
            }
            users = temp;
        }
    }

    @Override
    public void removeAt(int index) {
        if (index >= 0 && index <= (users.length - 1)) {
            User[] temp = new User[users.length - 1];
            for (int i = 0; i < index; i++) {
                temp[i] = users[i];
            }

            for (int i = index; i < temp.length; i++) {
                temp[i] = users[i + 1];
            }
            users = temp;
        }
    }

    public void show() {
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
    }

    public int getAverageUsersAge() {
        int totalAge = 0;
        for (User user : users) {
            totalAge += user.getAge();
        }
        return totalAge / users.length;
    }

    @Override
    public int getSize() {
        return users.length;
    }
}
