package dz8;

import dz8.figures.Circle;
import dz8.figures.Figure;
import dz8.figures.Squere;
import dz8.figures.Triangle;
import dz8.obstacles.Obstacle;
import dz8.obstacles.Racetrack;
import dz8.obstacles.Wall;
import dz8.participants.Cat;
import dz8.participants.Human;
import dz8.participants.Participant;
import dz8.participants.Robot;

public class Main {

    public static void main(String[] args) {

        Figure[] figures = new Figure[]{
                new Circle(13),
                new Squere(5),
                new Triangle(10,12,45)
        };

        float total = 0;
        for (Figure figure: figures){
            total+=figure.getArea();
        }
        System.out.println(total);

        String s = "_";
        System.out.println(s.repeat(100));

        Obstacle[] obstacles = new Obstacle[]{
                new Racetrack(50),
                new Wall(10),
                new Racetrack(150),
                new Wall(10),
                new Racetrack(200)
        };
        Participant[] participants = new Participant[]{
                new Human(),
                new Cat(),
                new Robot()
        };

        for(Participant participant: participants){
            boolean finished = true;
            for (Obstacle obstacle: obstacles){
                if(!participant.overcome(obstacle)){
                    finished = false;
                    break;
                }
            }
            if(finished) {
                System.out.println(participant.getName() + " дойшов до фінішу, пройшовши дистанцію: " + participant.getTotalDistance());
            }
        }
    }
}
