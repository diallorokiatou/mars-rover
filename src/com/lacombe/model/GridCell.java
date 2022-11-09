package src.com.lacombe.model;

public class GridCell {
    public Point point;
    public boolean hasObstacle;

    public GridCell(Point point) {
        this.point = point;
        this.hasObstacle = false;
    }

    public void setObstacle() {
        hasObstacle = true;
    }
}
