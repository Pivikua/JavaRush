package com.javarush.task.task31.task3104;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

/* 
Поиск скрытых файлов
// Программа работает как следует.
*/
public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("E:/"), options, 5, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(Paths.get(file.toFile().getName()).toString().endsWith(".zip") || Paths.get(file.toFile().getName()).toString().endsWith(".rar")) {
            archived.add(file.toFile().getAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {

            failed.add(file.toFile().getAbsolutePath());
            return FileVisitResult.SKIP_SUBTREE;
        /*if(Files.isRegularFile(Paths.get(file.toFile().getName()))) {
            failed.add(Paths.get(file.toFile().getName()).toString());*/
        //System.out.print(".");
           // return FileVisitResult.SKIP_SUBTREE;
        //} else
        //return super.visitFileFailed(file, exc);
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

}
