package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        load(inputStream);
        Enumeration enumeration = prop.keys();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement().toString();
            properties.put(key, prop.getProperty(key));
        }
        inputStream.close();
        reader.close();*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        InputStream inputStream = new FileInputStream(file);
        load(inputStream);
        reader.close();
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        /*PrintStream printStream = new PrintStream(outputStream);
        if (prop.size() > 0) {
            prop.putAll(properties);
        }
        prop.store(printStream, "");
        printStream.close();*/

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        for(Map.Entry<String, String> pair: properties.entrySet()){
            bufferedWriter.write(pair.getKey()+"="+pair.getValue()+"\r\n");
        }
        bufferedWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        /*if (inputStream.available() > 0) {
            prop.load(inputStream);
        }
        inputStream.close();*/

        Properties property = new Properties();
        property.load(inputStream);
        for(Map.Entry<Object, Object> pair: property.entrySet()){
            properties.put(pair.getKey().toString(), pair.getValue().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        /*reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        OutputStream outputStream = new FileOutputStream(reader.readLine());
        solution.save(outputStream);

        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + " : " + value);
        }*/
        Solution s = new Solution();
        s.fillInPropertiesMap();
        FileOutputStream fo = new FileOutputStream("E:/test/file.properties");
        s.save(fo);
        fo.close();
    }
}
