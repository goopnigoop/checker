package com.goonigoop.functioninterfaces.ch1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DataInputStreamOpener implements InputStreamOpener {
    @Override
    public InputStream open(String name) {
        try {
            return new DataInputStream(new FileInputStream(name));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
