package dz8.figures;

public class Circle implements Figure{
    float pi = 3.14F;
    float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (radius*radius)*pi;
    }
}
