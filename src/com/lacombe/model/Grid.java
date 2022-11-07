package src.com.lacombe.model;

import java.util.List;

public class Grid {
    public List<Point> obstacles;
    int capacity;

    public Grid(int capacity, List<Point> obstacles) {
        this.capacity = capacity;
        this.obstacles = obstacles;
    }

    public boolean hasObstacle(Point point, String message){
        if(obstacles.contains(point))
            throw new RuntimeException("An obstacle is detected at position " +  point.toString() + message );
        return false;
    }
}
