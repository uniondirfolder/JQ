package itstep.hw.d20072021.data.table;


import itstep.hw.d20072021.data.capsula.Developer;
import itstep.hw.d20072021.data.capsula.User;
import itstep.hw.d20072021.data.container.AbstractContainer;

@Developer
public final class ItemsUser extends AbstractContainer implements InterfaceUsers {


    private User getCopy(Object obj) {
        if (obj != null) {
            User user = (User) obj;
            User copy = new User(user.getName(), user.getAge());
            return copy;
        }
        return null;
    }

    @Override
    public User userGet(int index) {
        return getCopy(super.getRef(index));
    }


    @Override
    public User userGetFirst() {
        return getCopy(super.getFirstRef());
    }

    @Override
    public User userGetLast() {
        return getCopy(super.getLastRef());
    }


    public User[] userGetAll() {
        int count = super.getCount();
        if (count == 0) return null;

        User[] copyArray = new User[count];
        int it = 0;
        while (it < count) {
            copyArray[it] = userGet(it);
            ++it;
        }
        return copyArray;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        User[] tmp = userGetAll();
        sb.append("{\n");
        for (User user : tmp) {
            sb.append("\t" + user.toString()+ ',' + '\n');
        }
        sb.append("}\n");
        return sb.toString();
    }


}
