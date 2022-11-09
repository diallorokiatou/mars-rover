package src.com.lacombe.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid {
    public Set<Point> obstacles;
    int size;

    public Grid(int size, Point ...obstaclePoints) {
        this.size = size;
        obstacles = Arrays.stream(obstaclePoints).filter(Point::isLessOrEqualToCapacity).collect(Collectors.toSet());
    }

    public boolean hasObstacleAt(Point point){
        return obstacles.contains(point);
    }

    public int getSize() {
        return size;
    }
}
