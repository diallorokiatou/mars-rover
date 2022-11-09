package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;

import java.util.*;

public class Grid {
    public  Set<GridCell> cells;

    public Grid(int size, Point ...obstaclePoints) {
        this.cells = new HashSet<>();
        initGrid(size, obstaclePoints);
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
                GridCell cell = new GridCell(point);
                if(obstaclesList.contains(point))
                    cell.makeImpassable();
                cells.add(cell);
            }
        }
    }

    public Point pointAt(int x, int y){
        Point point = new Point(wrapEdges(x), wrapEdges(y));
        return cells.stream().filter(cell -> cell.sameAs(point)).findFirst().orElseThrow().point();
    }

    private List<Point> toList(Point ...obstaclePoints) {
        if(obstaclePoints == null) return Collections.emptyList();
        return  Arrays.asList(obstaclePoints);
    }

    public boolean hasObstacleAt(Point point){
        return cells.stream().anyMatch(cell -> cell.sameAs(point) && cell.hasObstacle());
    }

    public boolean contains(Point point) {
        return cells.stream().noneMatch(gridCell -> gridCell.sameAs(point));
    }

    public Point moveForward(Point point, Direction direction) {
        Point nextPoint = direction.moveForward(point);
        return pointAt(nextPoint.x(), nextPoint.y());
    }

    public Point moveBackward(Point point, Direction direction) {
        Point nextPoint = direction.moveBackward(point);
        return pointAt(nextPoint.x(), nextPoint.y());
    }

    public int wrapEdges(int number){
        if(isNumberSuperiorThanWidth(number))
            return 1;
        if(isNumberEqualToZero(number))
            return getWidth();
        return number;
    }

}
