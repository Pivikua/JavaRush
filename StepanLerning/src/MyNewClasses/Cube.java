package MyNewClasses;

public class Cube {
    int length;

    public Cube(int length) {
        this.length = length;
    }

    public int Volume() {
        return length * length * length;
    }

    public int Scuare() {
        return 6 * length * length;
    }

    public int DlinReb(){
        return length * 12;
    }
}
