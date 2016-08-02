package com.training.core.util;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
/**
 * Created by Athos on 2016-08-02.
 */
public class LogUtil {
    private static Logger debugLogger = null;
    private static Logger errorLogger = null;
    private static Logger infoLogger = null;

    private static Logger countTimeLogger=null;


    static {
        loadLogger();
    }

    public LogUtil() {
        super();
    }

    /**
     * 装载系统使用的log
     */
    static void loadLogger() {
        debugLogger = Logger.getLogger("");
        infoLogger = Logger.getLogger("info");
        errorLogger = Logger.getLogger("error");

        countTimeLogger = Logger.getLogger("countTimeLogger");
    }
    public static void countTimeLog(Object msg) {
        countTimeLogger.info(msg);
    }

    public static void countTimeLog(Object msg,Exception e) {
        countTimeLogger.info(msg+"\n"+getExceptionTrace(e));
    }


    /**
     * @param msg: error级别的错误信息
     */
    public static void errorLog(Object msg) {
        errorLogger.error(msg);
    }

    /**
     * @param e: error级别的异常信息
     */
    public static void errorLog(Exception e) {
        errorLogger.error(getExceptionTrace(e));
    }

    /**
     * @param e: error级别的异常信息
     * @param msg: error级别的错误信息
     */
    public static void errorLog(Exception e, Object msg) {
        errorLogger.error(msg + "\n" + getExceptionTrace(e));
    }

    /**
     * @param msg: debug级别的错误信息
     */
    public static void debugLog(Object msg) {
        debugLogger.debug(msg);
    }

    /**
     * @param e: debug级别的异常信息
     */
    public static void debugLog(Exception e) {
        debugLogger.debug(getExceptionTrace(e));
    }

    /**
     * @param e: debug级别的异常信息
     * @param msg: debug级别的错误信息
     */
    public static void debugLog(Exception e, Object msg) {
        debugLogger.debug(msg + "\n" + getExceptionTrace(e));
    }

    /**
     * @param msg: info级别的错误信息
     */
    public static void systemLog(Object msg) {
        infoLogger.info(msg);
    }

    /**
     * @param e: info级别的异常信息
     */
    public static void systemLog(Exception e) {
        infoLogger.info(getExceptionTrace(e));
    }

    /**
     * @param e: debug级别的异常信息
     * @param msg: debug级别的错误信息
     */
    public static void systemLog(Exception e, Object msg) {
        infoLogger.info(msg + "\n" + getExceptionTrace(e));
    }

    /**
     * @param e: 异常信息输出
     */
    public static void exOut(Exception e) {
        String print = getExceptionTrace(e);
        errorLogger.error(print);
    }

    /**
     * @param e: debug级别的异常信息
     * @param : debug级别的错误信息
     */
    private static String getExceptionTrace(Exception e) {
        String print = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintWriter wrt = new PrintWriter(bout);
        e.printStackTrace(wrt);
        wrt.close();
        print = bout.toString();
        return print;
    }
}
