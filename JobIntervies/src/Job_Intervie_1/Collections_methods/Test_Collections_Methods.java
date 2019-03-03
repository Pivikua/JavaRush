package Job_Intervie_1.Collections_methods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Test_Collections_Methods {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> destArrayList = new ArrayList<>();
        String[] names = {"Sergey", "Olja", "Natasha"};
        String[] destNames = new String[3];
        // public static <T> boolean addAll(Collection<? super T> c, T... elements)
        // Метод добавляет элементы массива elements в коллекцию Collection<? super T> c.
        // Элементы могут быть указаны по одиночке, либо как массив.
        // Когда элементы указанны по отдельности данный метод предоставляет возможность удобно
        //       добавить все элементы в имеющуюся коллекцию:

        Collections.addAll(arrayList, "Stepan", "Aleksandr", "Elena", "Sofija");
        Collections.addAll(destArrayList, null, null, null, null, null, null, null, null);
        Collections.addAll(arrayList, names);

        // public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
        // public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)

        // Оба метода ищут в списке переданном в параметре объект переданный в параметре используя
        // алгоритм двоичного поиска. Возвращают индекс элемента, если такой элемент в списке есть,
        // иначе индекс первого элемента списка большего key, если все элементы меньше key, возвращает list.size().

        // Перед использованием данных методов списки должны быть отсортированы.
        // В первом случае отсортированы по возрастанию в "естественном" порядке следования элементов списка
        // (такой же, как при использовании Collections.sort(list)).
        // Во втором случае список должен быть отсортирован по возрастанию в порядке следования, который обеспечивает
        // переданный компаратор (такой же порядок, как при использовании Collections.sort(list, c)
        // [здесь "с" - компаратор из параметров описываемого метода])

        Collections.sort(arrayList);
        int sortedNamePosition;
        sortedNamePosition = Collections.binarySearch(arrayList, "Sofija");
        System.out.println(sortedNamePosition);

        // public static <E> Collection<E> checkedCollection(Collection<E> c, Class<E> type)
        //
        // Преамбула:
        // Механизм дженериков в языке обеспечивает проверку типов во время компиляции.
        // Обычно этого и достаточно, однако бывают случаи, когда все-таки нет.
        // К примеру мы нашу коллекцию передаем в код библиотеки, куда-нибудь на сторону, нам неизвестную,
        // и нам очень сильно хочется, чтоб код этой "third-party library" не вставил в нашу коллекцию элемент
        // неправильного типа. Это вот возможная проблема номер 1.
        // Возможная проблема номер 2 следующая.
        // Предположим наша программа выдает нам ClassCastException, который оповещает нас о том,
        // что в коллекцию был вставлен элемент неправильного типа. К сожалению данное исключение может вылететь
        // в любой момент, после того, как неправильный элемент был вставлен, и обычно предоставляет нам совсем
        // немного или вообще ноль информации об источнике проблемы.
        //
        // Используя метод метод checkedCollection мы можем избавить себя от проблемы один и два, т.к. этот метод
        // создает коллекцию проверяемую на этапе выполнения.

        //        Решение проблемы номер два, с помощью данного метода:
        //        К примеру мы имеем вот это, и у нас вываливается ClassCastException.
        Collection<String> c = new HashSet<String>();
        //        При запуске следующего кускапрограммы снова мы локализуем строку кода, которая вставляет
        //              элемент неправильного типа в нашу коллекцию.
        //        Код выше можно временно заменить на:
        Collection<String> collection = Collections.checkedCollection(new HashSet<String>(), String.class);

        // public static <T> void copy(List<? super T> dest,List<? extends T> src)
        // Метод копирует элементы src в dest. индексы у копированных элементов будут совпадать.

        Collections.copy(destArrayList, arrayList);

        for (String s : destArrayList) {
            System.out.println(s);
        }

        System.out.println();

        // public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)
        // public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
        // public static <T> T min(Collection<? extends T> coll,Comparator<? super T> comp)
        // public static <T> T max(Collection<? extends T> coll,Comparator<? super T> comp)
        //
        // методы возвращают минимальный\максимальный элемент в коллекции с точки зрения "естественного порядка"
        // (интерфейс Comparable) либо порядка переданного компаратора.

        System.out.println("min " + Collections.min(arrayList));
        System.out.println("max " + Collections.max(arrayList));
        System.out.println();

        // public static boolean disjoint(Collection<?> c1,Collection<?> c2)
        // Возвращает true если у коллекций нет одинаковых элементов.

        System.out.println("В коллекциях все элементы разные " + Collections.disjoint(arrayList, destArrayList));

        // <T> List <T> emptyList(), <K,V> Map <K,V> emptyMap(),
        // <T> Set <T> emptySet()
        // – возвращают пустой список, карту отображения и множество соответственно, и другие коллекции.

        Collections.emptyList();
        Collections.emptyMap();
        Collections.emptySet();
        //....

        // <T> void fill(List<? super T> list, T obj) – заполняет список заданным элементом ;


        // int frequency(Collection<?> c, Object o) – возвращает количество вхождений в коллекцию заданного элемента;


        // <T> List <T> nCopies(int n, T o) – возвращает список из n заданных элементов;


        // <T> boolean replaceAll(List<T> list, T oldVal, T newVal) – заменяет все заданные элементы новыми;


        // void reverse(List<?> list) – “переворачивает” список;


        // void rotate(List<?> list, int distance) – сдвигает список циклически на заданное число элементов;


        // void shuffle(List<?> list) – перетасовывает элементы списка;


        // <T> Set <T> singleton(T o), singletonList(T o), singletonMap(K key, V value) – создают множество, список и карту отображения, состоящие из одного элемента;


        // <T extends Comparable<? super T>> void sort(List<T> list),
        // <T> void sort(List<T> list, Comparator<? super T> c) – сортировка списка, естественным порядком и используя Comparator соответственно;

        // void swap(List<?> list, int i, int j) – меняет местами элементы списка стоящие на заданных позициях.
    }
}
