package org.apache.nanodb.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private final static String NANODB_FILE_CONF = "nano-conf.properties";

    public static Properties CONF = null;

    static {
        InputStream confStream = null;
        try {
            CONF = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            if(classLoader == null) {
                classLoader = Configuration.class.getClassLoader();
            }

            confStream = classLoader.getResourceAsStream(NANODB_FILE_CONF);
            if(confStream != null) {
                CONF.load(confStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                confStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
