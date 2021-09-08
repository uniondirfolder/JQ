package itstep.hw.d19072021.data.table;


import itstep.hw.d19072021.data.capsula.Developer;
import itstep.hw.d19072021.data.capsula.User;

@Developer
public interface InterfaceUsers {
    User userGet(int index);

    User userGetFirst();
    User userGetLast();
    User[] userGetAll();
}
