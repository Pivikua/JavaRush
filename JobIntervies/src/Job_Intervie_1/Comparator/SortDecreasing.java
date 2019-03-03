package Job_Intervie_1.Comparator;

import java.util.Comparator;

public class SortDecreasing implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o2.getAge() - o1.getAge();
    }
}
