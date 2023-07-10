package dz19;

public class Main {
    public static void main(String[] args) {
        try {
            TestRunner.start(new Tests());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
