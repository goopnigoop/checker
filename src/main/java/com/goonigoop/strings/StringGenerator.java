package com.goonigoop.strings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class StringGenerator {
    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();


    public String generateFile(String pathname, int mb) throws IOException {


        final File file = new File(pathname);
        file.delete();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        while (file.length() < 1024 * 1024 * mb) {
            bufferedWriter.write(generateLine());
            if (file.length() > 1024) {
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }


        bufferedWriter.close();

        return pathname;
    }


    private String generateLine() {
        final int length = threadLocalRandom.nextInt(30);
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (char) (threadLocalRandom.nextInt(26) + 'a');
        }


        return new String(arr) + " ";
    }


    public static void main(String[] args) throws IOException {
        StringGenerator stringGenerator = new StringGenerator();
        stringGenerator.generateFile("temp.log",12);
    }
}
