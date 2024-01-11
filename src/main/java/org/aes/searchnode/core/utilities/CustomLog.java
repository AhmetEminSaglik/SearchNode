package org.aes.searchnode.core.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomLog {

    private final Logger log;

    public CustomLog(Class clazz) {
        log = LoggerFactory.getLogger(clazz);
    }

    public void info(String text) {
        log.info(text);
    }

    public void warn(String text) {
        log.warn(text);
    }

    public void error(String text) {
        log.error(text);
    }


}
