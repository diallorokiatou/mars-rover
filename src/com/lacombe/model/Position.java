package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;
import src.com.lacombe.Enum.Move;

import java.util.Objects;

public class Position {
    Coordinate coordinate;
    Direction direction;

    public Position(int x, int y, char direction) {
        this.coordinate = new Coordinate(x,y);
        this.direction = Direction.getByChar(direction);
    }

    public void moveForward(){
        switch (direction){
            case East:
                coordinate.moveForwardEast();
                break;
            case West:
                coordinate.moveForwardWest();
                break;
            case North:
                coordinate.moveForwardNorth();
                break;
            case South:
                coordinate.moveForwardSouth();
                break;
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return  coordinate + ":" + direction.getDirectionSymbole() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return direction == position.direction && Objects.equals(coordinate, position.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, direction);
    }
}
