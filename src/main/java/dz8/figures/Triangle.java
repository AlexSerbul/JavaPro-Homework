package dz8.figures;

public class Triangle implements Figure{
    float side1;
    float side2;
    float angle;

    public Triangle(float side1, float side2, float angle) {
        this.side1 = side1;
        this.side2 = side2;
        this.angle = angle;
    }

    @Override
    public float getArea() {
        return (float) (0.5 * side1 * side2 * Math.sin(angle));
    }
}
