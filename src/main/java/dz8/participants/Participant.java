package dz8.participants;

import dz8.obstacles.Obstacle;
import dz8.obstacles.Racetrack;
import dz8.obstacles.Wall;

public class Participant {
    private String name;
    private int runLimit;
    private int jumpLimit;

    private int totalDistance;

    public Participant(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.totalDistance = 0;
    }

    public void run(Racetrack racetrack){
        System.out.println("Учасник "+ this.name + " пройшов перешкоду " + racetrack.getType() +" на дистанції "+ this.totalDistance);
        this.totalDistance+=racetrack.getLength();
    }
    public void jump(Wall wall){
        System.out.println("Учасник "+ this.name + " пройшов перешкоду " + wall.getType() +" на дистанції "+ this.totalDistance);
        this.totalDistance+=wall.getHeight();
    }
    private void stop(Obstacle obstacle){
        System.out.println("Учасник "+ this.name + " не пройшов перешкоду " + obstacle.getType() +" на дистанції "+ this.totalDistance);
    }

    public boolean overcome(Obstacle obstacle){
        boolean result = true;
        switch (obstacle.getType()){
            case "Стіна":
                if(this.jumpLimit>=((Wall) obstacle).getHeight()){
                    this.jump((Wall) obstacle);
                }else {
                    this.stop(obstacle);
                    result = false;
                }
                break;
            case "Доріжка":
                if(this.runLimit>=((Racetrack) obstacle).getLength()){
                    this.run((Racetrack) obstacle);
                }else {
                    this.stop(obstacle);
                    result = false;
                }
                break;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }
}
