package Job_Intervie_1.Comparator;

import java.util.TreeSet;

public class Comparator_Interface_Lerning {
    public static void main(String[] args) {

        TreeSet<Human> humans = new TreeSet<>(new SortAgeName());
        humans.add(new Human(12, "Annet"));
        humans.add(new Human(9, "Sergio"));
        humans.add(new Human(12, "Atex"));
        humans.add(new Human(10, "Paul"));
        humans.add(new Human(28, "Greg"));
        humans.add(new Human(11, "Milana"));
        //humans.add(null);

        for (Human human : humans) {
            System.out.println(human + " " + human.getAge() + " " + human.getName());
        }
    }
}
