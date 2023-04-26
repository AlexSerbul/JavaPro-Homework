package dz8.obstacles;

public class Wall extends Obstacle{

    private int height;

    public Wall(int height) {
        super("Стіна");
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
