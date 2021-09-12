package lection.l8_l9_stream_api.sort;

import java.util.Comparator;

public class PersonLastNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
