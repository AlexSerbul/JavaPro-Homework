package dz8.figures;

public interface Figure {
    public default float getArea() {
        return 0;
    }
}
