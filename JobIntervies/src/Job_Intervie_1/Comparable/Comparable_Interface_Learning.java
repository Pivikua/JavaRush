package Job_Intervie_1.Comparable;

/*
1. Как пользоваться интерфейсом Comparable?

В интерфейсе Comparable объявлен всего один метод compareTo(Object obj), предназначенный для реализации упорядочивания
объектов класса. Его удобно использовать при сортировке упорядоченных списков или массивов объектов.

Данный метод сравнивает вызываемый объект с obj. В отличие от метода equals, который возвращает true или false,
compareTo возвращает:
0, если значения равны;
Отрицательное значение, если вызываемый объект меньше параметра;
Положительное значение , если вызываемый объект больше параметра.


Прежде всего он удобен для сортировки упорядоченных списков (java.util.List) и массивов объектов. Если список/массив
содержит элементы, реализующие этот интерфейс, то они могут быть отсортированы автоматически методами
java.util.Collections.sort(List)/Arrays.sort(Object[]).

С интерфейсом Comparable связано понятие натурального упорядочивания, потому как он устанавливает натуральный порядок
следования экземпляров любого класса, реализующего этот интерфейс. Иначе говоря, порядок (x, y) соответствует выполнению
условия x.compareTo(y) <= 0.

Правила реализации Comparable, а вернее, его метода compareTo(Object) следующие (x и y – экземпляры класса, реализующег
 Comparable):
    - x.compareTo(y) возвращает -1 или 1, если x должен находиться, соответственно, раньше или позже y. Если метод
        возвращает 0, то порядки (x, y) и (y, x) эквивалентны.
    - Если sign(a) – функция, возвращающая -1,0,1 для а, соответственно, меньше 0, равного 0 и больше 0, то должно
        выполняться равенство sign(x.compareTo(y))==-sign(y.compareTo(x)). Что логично: если x идет раньше y, то
        y должен идти позже x, и наоборот.
    - Если x.compareTo(y) > 0 и y.compareTo(z) > 0, то x.compareTo(z) > 0 – соотношение транзитивности неравенств.
    - Если x.compareTo(y) == 0, то sign(x.compare(z)) == sign(y.compareTo(z)), для любых z.
    - Вызов x.compareTo(null) должен бросать исключение NullPointerException. В этом есть расхождение с логикой
        реализации equals (напомню, x.equals(null) возвращает false).
    - Если y по своему типу не может быть сравнен с x, то вызов x.compareTo(y) должен
        бросать исключение ClassCastException.
    - (x.compareTo(y) == 0) == x.equals(y), т.е. вызов x.compareTo(y) должен возвращать 0 тогда и только тогда,
        когда x.equals(y) возвращает true. Это правило непротиворечивости, и его очень важно учитывать.


Источники:
http://echuprina.blogspot.ru/2012/02/comparable-comparator.html
http://www.skipy.ru/technics/objCompTh.html#comparable

*/

import java.util.ArrayList;
import java.util.Collections;

public class Comparable_Interface_Learning {

    public static void main(String[] args) {

        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human(12));
        humans.add(new Human(9));
        humans.add(new Human(18));
        humans.add(new Human(10));
        humans.add(new Human(28));
        humans.add(new Human(11));
        //humans.add(null);


        try {
            Collections.sort(humans);
        } catch (Exception e) {
            System.out.println("NullPointerException");
        }

        for (Human human : humans) {
            System.out.println(human + " " + human.getAge());
        }


    }
}
