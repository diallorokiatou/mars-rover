package src.com.lacombe.model;

public class GridCell {
    Coordinate coordinate;
    boolean hasObstacle;

    public GridCell(int abcissa, int ordonna) {
        this.coordinate = new Coordinate(abcissa, ordonna);
        this.hasObstacle = false;
    }

    public boolean haveSameCordinate(Coordinate coordinate) {
        return this.coordinate.equals(coordinate);
    }

    @Override
    public String toString() {
        if(hasObstacle) return "o:" + coordinate.toString();
        return coordinate.toString();
    }

    public void setObstacle() {
        hasObstacle = true;
    }
}
