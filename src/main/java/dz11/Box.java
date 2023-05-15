package dz11;

import java.util.ArrayList;
import java.util.List;

public class Box<F extends Fruit> {
    private List<F> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addOne(F fruit){
        this.fruits.add(fruit);
    }

    public void addSome(F[] fruits){
        for(F f: fruits){
            this.fruits.add(f);
        }
    }

    public float getWeight(){
        float total_weight = 0;
        for(F f:this.fruits){
            total_weight+=f.getMass();
        }
        return total_weight;
    }

    public boolean compare(Box box){
        boolean result = false;
        if(this.getWeight()==box.getWeight()){
            result = true;
        }
        return result;
    }

    public void merge(Box<F> box){
        this.fruits.addAll(box.fruits);
    }
}
