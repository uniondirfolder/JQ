package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Singleton;

public class ProgramLogger {
    private static ProgramLogger programLogger;
    private static String logFile = "This is log file.\n================\n";

    private ProgramLogger() {}

    public static synchronized ProgramLogger getProgramLogger() {
        if(programLogger == null) {
            programLogger = new ProgramLogger();
        }
        return programLogger;
    }

    public void addLoginfo(String logInfo) {
        logFile += logInfo +"\n";
    }

    public void showLogFile() {
        System.out.println(logFile);
    }
}
