package com.trendyolselenium.framework.utilities;

import org.apache.log4j.Logger;

public class logUtil {
    private static final Logger Log = Logger.getLogger(logUtil.class.getName());
    public static void infoLog(String messsage){
        Log.info(messsage);
    }
    public static void warn(String message){
        Log.warn(message);
    }
    public static void error(String message){
        Log.error(message);
    }
    public static void InitializeTest(){
        Log.info("---------------------------------------------------------");
        Log.info("Test is about to start");
        Log.info("---------------------------------------------------------");
    }
    public static void TestEnding(){
        Log.info("---------------------------------------------------------");
        Log.info("Test is about to end");
        Log.info("---------------------------------------------------------");
    }

}
