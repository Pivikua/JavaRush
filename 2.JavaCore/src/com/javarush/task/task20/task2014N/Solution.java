package com.javarush.task.task20.task2014N;
/*
Требования:
1. Поле pattern должно быть отмечено модификатором transient.
2. Поле currentDate должно быть отмечено модификатором transient.
3. Поле temperature должно быть отмечено модификатором transient.
4. Поле string НЕ должно быть отмечено модификатором transient.
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.


*/
public class Solution implements Externalizable {
    public static void main(String[] args) {
        String fileName = "D:\\test\\0.txt";
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Solution savedObject = new Solution(5);
            savedObject.writeExternal(objectOutputStream);

            Solution loadedObject = new Solution(4);
            loadedObject.readExternal(objectInputStream);

            System.out.println(loadedObject.string);
            //System.out.println(savedObject.equals(loadedObject));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(temperature);
        out.writeObject(currentDate);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        temperature = in.readInt();
        currentDate = (Date) in.readObject();
    }

    @Override
    public String toString() {
        return this.string;
    }
}
