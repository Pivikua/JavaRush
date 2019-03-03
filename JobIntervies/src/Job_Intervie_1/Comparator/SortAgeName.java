package Job_Intervie_1.Comparator;

import java.util.Comparator;

public class SortAgeName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getAge() == o2.getAge()) {
            return o1.getName().compareTo(o2.getName());
        }
        return o2.getAge() - o1.getAge();
    }
}
