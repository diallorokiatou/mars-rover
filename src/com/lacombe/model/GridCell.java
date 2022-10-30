package src.com.lacombe.model;

import java.util.Objects;

public class GridCell {
    Coordinate coordinate;
    boolean hasObstacle;

    public GridCell(int abcissa, int ordonna) {
        this.coordinate = new Coordinate(abcissa, ordonna);
        this.hasObstacle = false;
    }

    public boolean equals(Position position) {
        return  coordinate.equals(position.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, hasObstacle);
    }

    @Override
    public String toString() {
        return "GridCell{" +
                coordinate.toString() +
                ";" + hasObstacle +
                '}';
    }
}
