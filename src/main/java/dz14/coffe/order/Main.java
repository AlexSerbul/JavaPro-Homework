package dz14.coffe.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add("Alex");
        orderBoard.add("Ron");
        orderBoard.add("Dobby");
        orderBoard.draw();
        orderBoard.deliver();
        orderBoard.add("Max");
        orderBoard.add("Garry");
        orderBoard.deliver(3);
        orderBoard.draw();
    }
}
