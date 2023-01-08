package org.apache.nanodb.storage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class NanoFile<T extends Serializable>
{
    private final File file;

    private RandomAccessFile accessFile; // 支持随机访问

    public NanoFile(File nanoFile) {
        this.file = nanoFile;
        try {
            this.accessFile = new RandomAccessFile(this.file, "rw");
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] readBytes(int pos) {
        byte[] data = new byte[1024];
        try {
            this.accessFile.seek(pos);
            this.accessFile.read(data, 0, data.length);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void writeBytes(byte[] data) {
        try {
            this.accessFile.write(data);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeObject(T content)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(content);
            out.flush();
            byte[] contentBytes = bos.toByteArray();
            this.accessFile.write(contentBytes);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
