package dz4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Cat cat1 = new Cat("Фелікс");
        cat1.swim(150);
        animals.add(cat1);
        Cat cat2 = new Cat("Борис");
        cat2.run(150);
        animals.add(cat2);
        Dog dog1 = new Dog("Шарик");
        dog1.run(750);
        animals.add(dog1);
        Dog dog2 = new Dog("Мухтар");
        dog2.swim(9);
        animals.add(dog2);
        Dog dog3 = new Dog("Бобік");
        dog3.swim(11);
        animals.add(dog3);

        System.out.println("Усього тварин: "+ Integer.toString(animals.size()));
        int dogs = 0;
        int cats = 0;
        for(int i=0;i<animals.size();i++){
            if (animals.get(i).getClass()==Cat.class) cats++;
            if (animals.get(i).getClass()==Dog.class) dogs++;
        }
        System.out.println("Собак: "+dogs+"\nКотів: "+cats);
    }
}