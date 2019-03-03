package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Path directory = Paths.get(bufferedReader.readLine());

        if (Files.isDirectory(directory)) {
            MyFileVisitor myFileVisitor = new MyFileVisitor();
            Files.walkFileTree(directory, myFileVisitor);
            System.out.println("Всего папок - " + (myFileVisitor.getDirsCounter() - 1));
            System.out.println("Всего файлов - " + myFileVisitor.getFileCounter());
            System.out.println("Общий размер - " + myFileVisitor.getDirSize());
        } else {
            System.out.println(directory.toString() + " - не папка");
        }
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {

    long dirsCounter, fileCounter, DirSize;

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        DirSize += fileAttributes.size();
        fileCounter++;
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        dirsCounter++;
        return FileVisitResult.CONTINUE;
    }

    public long getDirsCounter() {
        return dirsCounter;
    }

    public long getFileCounter() {
        return fileCounter;
    }

    public long getDirSize() {
        return DirSize;
    }
}