package com.nvv.itstep.hw.d17072021;


import static com.nvv.itstep.hw.d17072021.Position.FIRST;
import static com.nvv.itstep.hw.d17072021.Position.LAST;

public class ArrayUser {
    private User users[] = new User[0];

    public int size() {
        return users.length;
    }

    public User get(int index) {
        return new User(users[index].getName(), users[index].getAge());
    }

    public User getFirst() {
        return new User(users[0].getName(), users[0].getAge());
    }

    public User getLast() {
        int index = users.length - 1;
        return new User(users[index].getName(), users[index].getAge());
    }

    public void addFirst(User user) {
        add(FIRST, user);
    }

    public void addLast(User user) {
        add(LAST, user);
    }

    public void set(int index, User user) {
        users[index].setName(user.getName());
        users[index].setAge(user.getAge());
    }

    private void add(Position position, User user) {
        User newArr[] = new User[users.length + 1];
        int i = 0;
        switch (position) {
            case FIRST -> {
                newArr[0] = new User(user.getName(), user.getAge());
                i = 1;
            }
            case LAST -> {
                newArr[users.length] = new User(user.getName(), user.getAge());
            }
        }
        for (int k = 0; k < users.length; k++) {
            newArr[i] = new User(this.users[k].getName(), this.users[k].getAge());
            i++;
        }
        this.users = newArr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Users { ");
        for (int i = 0; i < users.length; i++) {
            sb.append(users[i]);
            sb.append(" ");
        }
        sb.append(" }");
        return sb.toString();
    }
}
