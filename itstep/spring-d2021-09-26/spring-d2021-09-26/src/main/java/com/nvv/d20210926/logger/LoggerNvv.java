package com.nvv.d20210926.logger;

import java.io.IOException;
import java.util.logging.*;


public class LoggerNvv {
    private final static LogManager lgMan;
    private final static String LOGGER_NAME;
    private final static Logger Log;
    private  static FileHandler fh;
    private static byte isInitialized;
    static {
        lgMan = LogManager.getLogManager();
        LOGGER_NAME = Logger.GLOBAL_LOGGER_NAME;
        Log = lgMan.getLogger(LOGGER_NAME);
        Log.setLevel(Level.ALL);
        isInitialized = -1;
        try {
            fh = new FileHandler("C:\\REPO\\JQ\\itstep\\spring-d2021-09-26\\spring-d2021-09-26\\src\\main\\java\\com\\nvv\\d20210926\\logger\\TheLog_%g.log",100,25);
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.FINE);
            Log.addHandler(fh);
            isInitialized = 1;
        } catch (IOException e) {
            try {
                isInitialized = 0;
                throw new Exception(LOGGER_NAME + " |> "+e.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Logger getCurrentLogger() throws Exception {
        if(isInitialized == 1){
            return Log;
        }
        else {
            throw new Exception(LOGGER_NAME + "isInitialized= "+ false);
        }
    }
}
