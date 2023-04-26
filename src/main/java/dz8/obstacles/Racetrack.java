package dz8.obstacles;

public class Racetrack extends Obstacle{
    private int length;

    public Racetrack(int length) {
        super("Доріжка");
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
