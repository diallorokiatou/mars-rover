package src.com.lacombe.model;

import java.util.*;

public class Grid {
    public  Set<GridCell> cells;

    public Grid(int size, Point ...obstaclePoints) {
        this.cells = new HashSet<>();
        initGrid(size, obstaclePoints);
    }

    public Point incrementY(Point point, int increment){
        if(isNumberSuperiorThanWidth(point.y() + increment))
            return new Point(point.x(), increment);
        if(isNumberEqualToZero(point.y() + increment))
            return new Point(point.x(), getWidth());
        return new Point(point.x(), point.y()+ increment);
    }

    public Point incrementX(Point point, int increment) {
        if(isNumberSuperiorThanWidth(point.x() + increment))
            return new Point(1,point.y());
        if(isNumberEqualToZero(point.x() + increment))
            return new Point(getWidth(),point.y());
        return new Point(point.x()+increment,point.y());
    }

    private boolean isNumberEqualToZero(int number) {
        return number == 0;
    }

    private  boolean isNumberSuperiorThanWidth(int number) {
        return number > getWidth();
    }

    public int getWidth() {
        return (int)Math.sqrt(cells.size());
    }

    private void initGrid(int size, Point[] obstaclePoints) {
        List<Point> obstaclesList = toList(obstaclePoints);
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                Point point = new Point(i, j);
                GridCell gridCell = new GridCell(point);
                if(obstaclesList.contains(point)) {
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

    public boolean contain(Point point) {
        return cells.stream().anyMatch(gridCell -> gridCell.point.equals(point));
    }
}
