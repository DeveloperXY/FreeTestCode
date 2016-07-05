package com.octagen.freetestcode.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class FileUtils {
    public String readFile(String filename) {
        String content = null;
        File file = new File(filename);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }
}
