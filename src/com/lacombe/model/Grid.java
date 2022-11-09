package src.com.lacombe.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid {
    public Set<GridCell> cells;
    int size;

    public Grid(int size, Point ...obstaclePoints) {
        this.size = size;
        this.cells = new HashSet<>(size);
        init();
        for(Point point : obstaclePoints){
            setObstacleAt(point);
        }
    }

    private void init() {
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                Point point = new Point(i, j, size);
                cells.add(new GridCell(point));
            }
        }
    }

    public void setObstacleAt(Point point){
        cells = cells.stream().peek(cell -> {
                    if(cell.point.equals(point)) cell.setObstacle();
                    }).collect(Collectors.toSet());
    }
    public boolean hasObstacleAt(Point point){
        return cells.stream().anyMatch(cell -> cell.point.equals(point) && cell.hasObstacle);
    }

    public int getSize() {
        return size;
    }
}
