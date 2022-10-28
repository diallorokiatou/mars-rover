package src.com.lacombe.model;

import java.util.Objects;

public class GridCell {
    Coordinate corCoordinate;
    boolean hasObstacle;

    public GridCell(int x, int y) {
        this.corCoordinate = new Coordinate(x,y);
        this.hasObstacle = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCell gridCell = (GridCell) o;
        return hasObstacle == gridCell.hasObstacle && Objects.equals(corCoordinate, gridCell.corCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(corCoordinate, hasObstacle);
    }

    @Override
    public String toString() {
        return "(" +
                " " + corCoordinate +
                "; " + hasObstacle +
                ')';
    }
}
