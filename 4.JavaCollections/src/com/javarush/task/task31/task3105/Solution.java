package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1], pathToZip = args[0];

        HashMap<ZipEntry, byte[]> entries = new HashMap<>();

        FileInputStream fileInputStream = new FileInputStream(pathToZip);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        ZipEntry tmpZE = null;
        byte[] buffer = null;

        while ((tmpZE = zipInputStream.getNextEntry()) != null) {
            buffer = new byte[(int)tmpZE.getSize()];
            zipInputStream.read(buffer);
            //System.out.println(buffer.length);
            entries.put(tmpZE, buffer);
            zipInputStream.closeEntry();
        }

        zipInputStream.close();

        File file = new File(fileName);
        fileInputStream = new FileInputStream(file);
        buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        entries.put(new ZipEntry("new/" + file.getName()), buffer);


        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(pathToZip));

        for (Map.Entry<ZipEntry, byte[]> pair : entries.entrySet()) {

            ZipEntry key = pair.getKey();                      //ключ
            byte[] value = pair.getValue();                     //значение
            System.out.println(key + " : " + value.length);

            zipOutputStream.putNextEntry(key);
            zipOutputStream.write(value);
            //zipOutputStream.closeEntry();
        }
        zipOutputStream.close();
    }
}
