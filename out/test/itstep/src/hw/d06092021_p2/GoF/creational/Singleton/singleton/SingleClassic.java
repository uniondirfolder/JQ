package hw.d06092021_p2.GoF.creational.Singleton.singleton;

public class SingleClassic {
    private static SingleClassic instance;

    private SingleClassic() {}
//    --synchronized version--
//    public static synchronized SingleClassic getInstance() { ...
    public static SingleClassic getInstance() {
        if (instance == null) {
            instance = new SingleClassic();
        }
        return instance;
    }
}
