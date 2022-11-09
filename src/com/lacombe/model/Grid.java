package src.com.lacombe.model;

import java.util.*;

public class Grid {
    public Set<GridCell> cells;

    public Grid(int size, Point ...obstaclePoints) {
        this.cells = new HashSet<>();
        List<Point> obtaclesList = toList(obstaclePoints);
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                Point point = new Point(i, j, size);
                GridCell gridCell = new GridCell(point);
                if(obtaclesList.contains(point)) {
                    gridCell.setObstacle();
                }
                cells.add(gridCell);
            }
        }
    }

    private List<Point> toList(Point ...obstaclePoints) {
        if(obstaclePoints == null) return Collections.emptyList();
        return  Arrays.asList(obstaclePoints);
    }

    public boolean hasObstacleAt(Point point){
        return cells.stream().anyMatch(cell -> cell.point.equals(point) && cell.hasObstacle);
    }

    public int getWidth() {
        return (int)Math.sqrt(cells.size());
    }
}
