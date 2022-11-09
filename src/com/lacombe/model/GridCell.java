package src.com.lacombe.model;

import java.util.Objects;

public class GridCell {
    private final Point point;
    private boolean hasObstacle;

    public GridCell(Point point) {
        this.point = point;
        this.hasObstacle = false;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isHasObstacle() {
        return hasObstacle;
    }

    public void makeImpassable() {
        hasObstacle = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCell gridCell = (GridCell) o;
        return hasObstacle == Objects.equals(point, gridCell.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, hasObstacle);
    }
}
