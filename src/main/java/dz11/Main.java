package dz11;

import dz8.figures.Squere;

import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.addOne(new Apple());
        appleBox.addOne(new Apple());
        appleBox.addOne(new Apple());

        orangeBox.addSome(new Orange[]{new Orange(),new Orange()});

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addSome(new Apple[]{new Apple(),new Apple(),new Apple()});

        appleBox.merge(appleBox2);
        System.out.println(appleBox.compare(orangeBox));
    }
}
