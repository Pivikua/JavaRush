package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputFileStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        byte[] lineBytes = new byte[50];
        Integer id = Integer.valueOf(0);
        Integer maxId = Integer.valueOf(0);

        String blanckStr;
        while(inputFileStream.available() > 0) {
            inputFileStream.read(lineBytes);
            blanckStr = (new String(lineBytes)).substring(0, 8);
            id = Integer.valueOf(Integer.parseInt(blanckStr.trim()));
            if(id.intValue() > maxId.intValue()) {
                maxId = id;
            }
        }

        maxId = Integer.valueOf(maxId.intValue() + 1);
        blanckStr = "                                                           ";
        String idStr = String.valueOf(maxId);
        idStr = idStr + blanckStr.substring(0, 8 - idStr.length());
        String productName = args[1] + blanckStr.substring(0, 30 - args[1].length());
        String price = args[2] + blanckStr.substring(0, 8 - args[2].length());
        String quantity = args[3] + blanckStr.substring(0, 4 - args[3].length());
        String newLine = "\n" + idStr + productName + price + quantity;
        System.out.println(newLine);
        lineBytes = newLine.getBytes("Cp1251");
        fileOutputStream.write(lineBytes);
        reader.close();
        inputFileStream.close();
        fileOutputStream.close();
    }
}
