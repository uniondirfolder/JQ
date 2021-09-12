package hw.d19072021.data.table;


import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.capsula.User;

@Developer
public interface InterfaceUsers {
    User userGet(int index);

    User userGetFirst();
    User userGetLast();
    User[] userGetAll();
}
