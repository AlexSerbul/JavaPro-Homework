package dz10;

public class Main {
    public static void main(String[] args) {
        ValueCalculator calculator = new ValueCalculator(1000000);
        try {
            calculator.FillWithOnes();
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

    }
}
