package Job_Intervie_1.Comparable;

class Human implements Comparable<Human> {
    private int age;

    public Human(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Human o) {
        return o.age - this.age;
    }

    public int getAge() {
        return age;
    }
}
