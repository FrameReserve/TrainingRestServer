package com.training.log4j;

import com.training.base.BaseTest;
import com.training.core.annotation.ServiceLog;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Athos on 2016-07-31.
 */
public class Log4jTest extends BaseTest {
    public static Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void logTest(){
        logger.error("c");
        logger.debug("a");
        logger.info("b");
        logger.error("c");
        logger.warn("d");
    }
}
