package src.com.lacombe.model;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    public Set<Point> obstacles;
    int capacity;

    public Grid(int capacity, Point ...points) {
        this.capacity = capacity;
        this.obstacles = new HashSet<>();
        setObstacles(points);
    }

    public void setObstacles(Point ...points){
        for(Point point : points){
            if(point.isLessOrEqualToCapacity())
                obstacles.add(point);
        }
    }

    public boolean hasObstacle(Point point){
        if(obstacles.contains(point))
            return true;
        return false;
    }

    public int getCapacity() {
        return capacity;
    }
}
