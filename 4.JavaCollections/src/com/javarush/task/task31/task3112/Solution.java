package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method

        // 1. Метод downloadFile должен создавать объект URL для переданной ссылки.
        URL url = new URL(urlString);

        //2. Метод downloadFile должен создать временный файл с помощью метода Files.createTempFile
        Path tmpFile = Files.createTempFile("dwld", ".tmp");

        //3. Метод downloadFile должен скачать файл по ссылке во временный файл, используя метод Files.copy
        //Files.createDirectory(downloadDirectory);
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, tmpFile);

        //4. Метод downloadFile должен переместить файл из временной директории в пользовательскую, используя метод Files.move
        Path fileNameFromLink  = Paths.get(downloadDirectory.toString() +
                "/" +
                urlString.split("/")[urlString.split("/").length - 1]);

        return Files.move(tmpFile, fileNameFromLink);
    }
}
