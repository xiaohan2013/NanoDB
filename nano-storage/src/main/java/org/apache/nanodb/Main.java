package org.apache.nanodb;

import org.apache.nanodb.config.Configuration;

public class Main {
    public static void main(String[] args) {
        String dataDir = Configuration.CONF.getProperty("data");
        System.out.println(dataDir);
    }
}