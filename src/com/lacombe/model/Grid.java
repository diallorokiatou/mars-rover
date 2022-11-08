package src.com.lacombe.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid {
    public Set<Point> obstacles;
    int capacity;

    public Grid(int capacity, Point ...obstaclePoints) {
        this.capacity = capacity;
        obstacles = Arrays.stream(obstaclePoints).filter(Point::isLessOrEqualToCapacity).collect(Collectors.toSet());
    }

    public boolean hasObstacleAt(Point point){
        return obstacles.contains(point);
    }

    public int getCapacity() {
        return capacity;
    }
}
