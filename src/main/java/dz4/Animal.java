package dz4;

public class Animal {
    private String name;
    public Animal(String name,int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    private static int maxRunDistance;
    private static int maxSwimDistance;
    public void run(int distance){
        if(maxRunDistance<=0){
            System.out.println(name + " не може бігати!");
        }else {
            if (distance > maxRunDistance) {
                System.out.println(name + " пробіг " + Integer.toString(maxRunDistance) + " та втомився");
            } else System.out.println(name + " пробіг " + Integer.toString(distance));
        }
    }
    public void swim(int distance){
        if(maxSwimDistance<=0){
            System.out.println(name + " не може плавати!");
        }else {
            if (distance > maxSwimDistance) {
                System.out.println(name + " проплив " + Integer.toString(maxSwimDistance) + " після чого втонув(");
            } else System.out.println(name + " проплив " + Integer.toString(distance));
        }
    }
}
