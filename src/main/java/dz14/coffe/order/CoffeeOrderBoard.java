package dz14.coffe.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> orderList;
    public int counter;

    public CoffeeOrderBoard() {
        this.orderList = new LinkedList<>();
        this.counter = 1;
    }

    public void add(String name){
        orderList.add(new Order(counter,name));
        counter++;
    }

    public void deliver(){
        orderList.poll();
    }
    public void deliver(int number){
        orderList.removeIf(order -> order.getNumber()==number);
    }

    public void draw(){
        System.out.println("Number | Name");
        for(Order order : orderList){
            System.out.println(order);
        }
    }
}
