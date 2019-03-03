package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
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

        String fileName = args[0];
        String zipFileName = args[1];
        File file = new File(fileName);
        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();
        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry entry;
            while ((entry = zipReader.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipReader.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);
                archivedFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }

        try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zipWriter.putNextEntry(new ZipEntry(pair.getKey()));
                zipWriter.write(pair.getValue().toByteArray());
            }

            ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
            zipWriter.putNextEntry(zipEntry);
            Files.copy(file.toPath(), zipWriter);
        }

        /*Map<String, byte[]> zipEntryArrayList = new HashMap<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]))){
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                byte[] bytes = new byte[zipInputStream.available()];
                zipInputStream.read(bytes);
                zipEntryArrayList.put(zipEntry.getSecond(), bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]))){
            File file = new File(args[0]);
            for (Map.Entry<String, byte[]> pair : zipEntryArrayList.entrySet()) {
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getSecond())) continue;
                zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutputStream.write(pair.getValue());
            }

            zipOutputStream.putNextEntry(new ZipEntry("new/" + args[0]));
            Files.copy(file.toPath(), zipOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
