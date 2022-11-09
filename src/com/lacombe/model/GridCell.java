package src.com.lacombe.model;

public class GridCell {
    private final Point point;
    private boolean hasObstacle;

    public GridCell(Point point) {
        this.point = point;
        this.hasObstacle = false;
    }

    public Point point() {
        return point;
    }

    public boolean hasObstacle() {
        return hasObstacle;
    }

    public void makeImpassable() {
        hasObstacle = true;
    }

    public boolean contains(Point point) {
        return this.point.equals(point);
    }

}
