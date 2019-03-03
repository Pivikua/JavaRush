package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        ArrayList<String> fileNameList = new ArrayList<>();
        ArrayList<File> fileList = new ArrayList<>();
        ArrayList<File> tmpFileList = new ArrayList<>();
        File file = new File(root);
        Path path = file.toPath();
        Collections.addAll(tmpFileList, file.listFiles());
        fileList.addAll(tmpFileList);

        for(int i = 0; i < fileList.size(); i++){
            if(fileList.get(i).isDirectory()){
                tmpFileList.clear();
                String newPath = fileList.get(i).getPath();
                File tmpFile = new File(newPath);
                fileList.remove(i);
                Collections.addAll(tmpFileList, tmpFile.listFiles());
                fileList.addAll(i, tmpFileList);
                i = 0;
            }
        }

        for (File fl: fileList) {
            fileNameList.add(fl.getPath());
        }

        return fileNameList;
    }

    public static void main(String[] args) {
        try {
            for (String x:getFileTree("E:/test")) {
                System.out.println(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
