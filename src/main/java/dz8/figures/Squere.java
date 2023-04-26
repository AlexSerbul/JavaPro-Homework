package dz8.figures;

public class Squere implements Figure{

    float side;

    public Squere(float side) {
        this.side = side;
    }

    @Override
    public float getArea() {
        return side*side;
    }
}
