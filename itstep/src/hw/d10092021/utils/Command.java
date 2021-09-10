package hw.d10092021.utils;

public interface Command<T, T1, T2> {
    String create(T db, T1 enm, T2 mdl);

    String read(T db, T1 enm, T2 mdl);

    String update(T db, T1 enm,  T2 mdl);

    String delete(T db, T1 enm,  T2 mdl);


}
