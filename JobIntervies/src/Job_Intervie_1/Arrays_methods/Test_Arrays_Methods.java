package Job_Intervie_1.Arrays_methods;

/*
Какие методы есть у класса Arrays?

Полный перечень методов класса Arrays можно увидеть в документации. В данном конспекте приведу лишь некоторые из них.
*/

import java.util.Arrays;
import java.util.List;

public class Test_Arrays_Methods {
    public static void main(String[] args) {

        // public static  <T>  List<T> asList(T... a)
        // формирует список на основе массива. Массив при этом используется для внутреннего представления списка.
        // Таким образом сохраняется связь между списком и исходным массивом:

        //изменения в массиве отразятся на списке:
        String[] a = { "foo", "bar", "baz"};
        List list = Arrays.asList(a);
        System.out.println(list); // [foo, bar, baz]
        a[0] = "aaa";
        System.out.println(list); // [aaa, bar, baz]

        //изменения в списке отразятся на массиве:
        String[] array = { "foo", "bar", "baz"};
        List listString = Arrays.asList(a);
        System.out.println(list); // [foo, bar, baz]
        list.set(0, "bbb");
        System.out.println(Arrays.toString(a)); // [bbb, bar, baz]

        //Если массив содержит объекты, очевидно, и массив и список будут ссылаться на одни и те же экземпляры:
        Object[] objects = { new Object(), new Object(), new Object()};
        List listo = Arrays.asList(a);
        System.out.println("Элементы массива и списка ссылаются на одни и те же экзампляры " + a[0] == list.get(0)); // true

        // int binarySearch(параметры) – перегруженный метод организации бинарного поиска значения в массивах
        // примитивных и объектных типов. Возвращает позицию первого совпадения

        int[] intArray = {12, 36, 24};
        System.out.println("Найденная позиция значения в массиве " + Arrays.binarySearch(intArray, 36));

        // void fill(параметры) – перегруженный метод для заполнения массивов значениями различных типов и примитивами;

        int[] intsArray = new int[5];
        Arrays.fill(intsArray, 10);
        System.out.print("Массив заполненный значением  - ");
        for (int i : intsArray) {
            System.out.print(i + ", ");
        }
        System.out.println();

        // void sort(параметры) – перегруженный метод сортировки массива или его части
        // с использованием интерфейса Comparator и без него

        Arrays.sort(intArray);
        System.out.print("Массив отсортированный  - ");
        for (int i : intArray) {
            System.out.print(i + ", ");
        }
        System.out.println();

        // static <T> T[] copyOf(T[] original, int newLength) –заполняет массив определенной длины,
        // отбрасывая элементы или заполняя null при необходимости

        intArray = Arrays.copyOf(intsArray, 12);
        System.out.print("Массив заполненный значением  - ");
        for (int i : intArray) {
            System.out.print(i + ", ");
        }
        System.out.println();

        // static <T> T[] copyOfRange(T[] original, int from, int to) –
        // копирует заданную область массива в новый массив;

        intArray = Arrays.copyOfRange(intsArray, 1, 5);

        //<T> List<T> asList(T… a) – метод, копирующий элементы массива в объект типа List<T>

    }
}
