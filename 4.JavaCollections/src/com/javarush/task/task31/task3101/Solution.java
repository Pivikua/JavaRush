package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws Exception{
        File path = new File (args[0]);
        File resultFileAbsolutePath = new File (args[1]);
        File dest = new File(resultFileAbsolutePath.getParent()+ "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, dest);
        ArrayList<File> list = new ArrayList<>();
        try (FileOutputStream writer = new FileOutputStream(dest)) {
            Files.walkFileTree(path.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().length() > 50) {
                        FileUtils.deleteFile(file.toFile());
                    } else {
                        list.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            Collections.sort(list, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });



            for (File file : list) {
                if (!file.equals(dest)) {
                    FileReader reader = new FileReader(file);
                    while (reader.ready()) writer.write(reader.read());
                    reader.close();
                    writer.write("\n".getBytes());
                }
            }
            writer.close();
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    /*public static void main(String[] args) {
        File pathToDirectory = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");

        FileList fileList = new FileList();

        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        fillFileList(pathToDirectory.getAbsolutePath());

        //int processors = Runtime.getRuntime().availableProcessors();
        //ForkJoinPool forkJoinPool = new ForkJoinPool(processors / 4);
        //fileList.addAll(forkJoinPool.invoke(new FileTree(pathToDirectory)));

        //List<File> fileList = readDirAndSubToFileList(pathToDirectory);
        //fileList.sort(Comparator.comparing(File::getSecond));
        fileList.getFileList().sort(new FileNameComparator());

        writeFileListToFile(allFilesContent, fileList.getFileList());

//        for (File file :fileList) {
//            System.out.println(file.getAbsolutePath());
//        }

    }

    private static void fillFileList(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath());
                continue;
            }
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else
                fileList.add(file);
        }
    }

//    private static List<File> readDirAndSubToFileList (File pathToDirectory) {
//        List<File> innerFileList = new ArrayList<>(); // Создаем объект списка для возващения
//        File[] files = pathToDirectory.listFiles(); // Получаем массив файлов корневой директории
//        fileArrayToFileList(innerFileList, files); // Добавляем массв в список
//        //ListIterator<File> listIterator = innerFileList.listIterator(); // Создание итератора для списка фалов
//        File currentFile; // Обект текущего файла.
//        boolean haveADirectory = false; // Флаг наличия в списке директорий. если да то пробегаем снова.
//        int i = 0;
//        do {
//            while (innerFileList.size() > i) {
//                currentFile = innerFileList.get(i);
//                System.out.println(currentFile.getSecond());
//                if(currentFile.isDirectory()) {
//                    haveADirectory = true;
//                    innerFileList.remove(currentFile);
//                    fileArrayToFileList(innerFileList, currentFile.listFiles());
//                }
//                i++;
//                //System.out.println(i);
//            }
//        } while (haveADirectory);
//        return innerFileList;
//    }
//
//    private static void fileArrayToFileList(List<File> fileList, File[] files) {
//        for (File file :files) {
//            fileList.add(file);
//        }
//    }

    // Запись финального списка в файл
    private static void writeFileListToFile(File fileToWrite, List<File> allFileList) {
        String stringOut;
        try {

            FileOutputStream fileOutputStream = new FileOutputStream(fileToWrite);
            try {
                for (File file : allFileList) {
                    stringOut = file.getAbsolutePath() + "\n";
                    fileOutputStream.write(stringOut.getBytes());
                }

                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Копаратор для сортировки списка
    private static class FileNameComparator implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            return o1.getSecond().compareTo(o2.getSecond());
        }
    }

//    private static class FileTree extends RecursiveTask<ArrayList<File>> {
//
//        File pathToDirectory;
//        static ArrayList<File> forkList = new ArrayList<>();
//
//        public FileTree(File pathToDirectory) {
//            this.pathToDirectory = pathToDirectory;
//        }
//
//        @Override
//        protected ArrayList<File> compute() {
//            if (pathToDirectory.isDirectory()) {
//                for (File file :pathToDirectory.listFiles()) {
//                    FileTree newFork = null;
//                    if (file.isDirectory()) {
//                        newFork = new FileTree(file);
//                        newFork.fork();
//                    } else {
//                        forkList.add(file);
//                    }
//                    //forkList.addAll(newFork.join());
//                }
//            }
//            return forkList;
//        }
//    }

    private static class FileList {
        private static List<File> fileList = new ArrayList<>();

        public static List<File> getFileList() {
            return fileList;
        }

        public void setFileList(List<File> fileList) {
            this.fileList = fileList;
        }
    }*/
}
