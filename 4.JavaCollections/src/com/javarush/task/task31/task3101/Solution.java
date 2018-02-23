package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {

    static ArrayList<File> fileArrayList = new ArrayList<>();

    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File filePath = new File(path);
        dirFileClean(filePath);
        fileArrayList = getDirFile(filePath);

        Collections.sort(fileArrayList, new Comparator<File>() {
            public int compare( File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        File resultFile = new File(resultFileAbsolutePath);
        File allFileContent = new File("E:/test/allFilesContent.txt");
        try {
            resultFile.createNewFile();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        FileUtils.renameFile(resultFile, allFileContent);

        Writer writer = null;
        try {
            String fileForWriter = allFileContent.getPath();
            writer = new FileWriter(fileForWriter);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        for (File file : fileArrayList) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    String str = reader.readLine();
                    writer.write(str);
                    writer.append('\n');
                    writer.flush();
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }



    public static ArrayList<File> getDirFile(File path) {
        File[] dirList = path.listFiles();
        for (File file : dirList) {
            if(file.isDirectory()) {
                getDirFile(file);
            } else {
                fileArrayList.add(file);
            }
        }
        return fileArrayList;
    }

    public static void dirFileClean(File path) {
        File[] dirList = path.listFiles();
        for (File file : dirList) {
            if(file.isDirectory()) {
                dirFileClean(file);
            } else chekSizeFileForDelete(file, 50);
        }
    }

    public static void chekSizeFileForDelete(File file, int fileSize) {
        if (file.length() > fileSize) {
            FileUtils.deleteFile(file);
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
