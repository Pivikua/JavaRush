package Job_Intervie_1.Comparator;

import java.util.Comparator;

public class SortAscending implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
