package hw.d06092021_p2.GoF.creational.Singleton;

public class ProgramRunner {

    public static void main(String[] args) {
//        System.out.println(ProgramLogger.class.getName().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());
        
        ProgramLogger.getProgramLogger().addLoginfo("First log...");
        ProgramLogger.getProgramLogger().addLoginfo("Second log...");
        ProgramLogger.getProgramLogger().addLoginfo("Third log...");

        ProgramLogger.getProgramLogger().showLogFile();
    }
}
