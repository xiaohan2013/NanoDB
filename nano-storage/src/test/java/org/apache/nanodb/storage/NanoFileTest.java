package org.apache.nanodb.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class NanoFileTest
{
    @BeforeEach
    void setUp(){
        System.out.println("before");
    }

    @Test
    void readBytes()
    {
        NanoFile nf = new NanoFile(new File("db.nf"));
        byte[] result = nf.readBytes(0);
        for (byte r : result) {
            System.out.println(result);
        }
    }

    @Test
    void writeBytes()
    {
    }

    @Test
    void writeObject()
    {
        NanoFile nf = new NanoFile(new File("db.nf"));
        nf.writeObject("abcd");
    }
}