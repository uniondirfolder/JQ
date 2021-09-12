package hw.d06092021_p2.GoF.behavioral.Iterator;

public class JDIterator implements Iterator {
    String[] skills;
    int index;

    public JDIterator(String[] skills) {
        super();
        this.skills = skills;
    }

    @Override
    public boolean hasNext() {
        if(index < skills.length) {
            return true;
        } else return false;
    }

    @Override
    public Object next() {
        return skills[index++];
    }
}
