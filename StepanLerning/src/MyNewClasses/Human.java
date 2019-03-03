package MyNewClasses;

public class Human {
    private String name;
    private int age;
    private int height;
    private boolean pol;

    public Human(String name, int age, int height, boolean pol) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.pol = pol;
    }

    public int getAge() {
        return age;
    }

    public void sayName() {
        System.out.println("Мое имя - " + name);
    }

    public void sayAge() {
        System.out.println("Мне - " + age + " лет.");
    }

    public void sayHeight() {
        System.out.println("Мой рост " + height + " см.");
    }

    public void sayUra3() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Ура!");
            for (int b = 0; b < 10; b++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }

    public void n10() {
        for (int i = 0; i < 10; i++) {
            System.out.print("n");
        }
        System.out.println();
    }

    public String OldYang() {
        String string = null;
        if (age > 50) {
            string = "Старый";
        }

        if (age < 50){
            string = "Молодой";
        }

        return string;
    }
}
