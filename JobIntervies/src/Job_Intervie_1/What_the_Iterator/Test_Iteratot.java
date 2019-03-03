package Job_Intervie_1.What_the_Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Test_Iteratot {
    public static void main(String[] args) {


        // Представленный в релизе JDK 1.2 языка Java интерфейс java.util.Iterator обеспечивает итерацию
        // контейнерных классов. Каждый Iterator реализует методы next() и hasNext() и дополнительно может
        // поддерживать метод remove(). Итераторы создаются соответствующими контейнерными классами,
        // как правило методом iterator().
        //
        // Метод next() переводит итератор на следующее значение и возвращает указываемое значение итератору.
        // При первоначальном создании итератор указывает на специальное значение, находящееся перед первым элементом,
        // поэтому первый элемент можно получить только после первого вызова next(). Для определения момента,
        // когда все элементы в контейнере были перебраны, используется тестовый метод hasNext().
        // Следующий пример демонстрирует простое использование итераторов:


        ArrayList<String> list = new ArrayList<String>();

        Collections.addAll(list, "String1", "String2", "String3", "String4", "String5", "String6");

        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            String string = iter.next().toString();
            if (string.equals("String4")) {
                iter.remove();
                string = "";
            }
            System.out.print(string + " ");
        }
        System.out.println();

        // Для коллекции типов, поддерживающей подобное, метод итератора remove() удаляет последний 'посещенный'
        // элемент из контейнера. Почти все остальные типы модификации контейнера во время итерации являются небезопасными.
        //
        // Кроме того, для java.util.List существует java.util.ListIterator со схожим API, но позволяющем прямую и
        // обратную итерации, обеспечивая определение текущего индекса в списке и переход к элементу по его позиции.
    }
}
