package dz11;

import java.util.Arrays;
import java.util.List;

public class Converter<T> {
    public List<T> toList(T[] items) {
        return Arrays.stream(items).toList();
    }
}
