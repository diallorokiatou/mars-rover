package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;

public class Position {
    Coordinate coordinate;

    Direction direction;

    public Position(int abscissa, int ordonna, char direction) {
        this.coordinate = new Coordinate(abscissa, ordonna);
        this.direction = Direction.getByChar(direction);
    }

    public Position(Position position) {
        this.coordinate = new Coordinate(position.coordinate.abscissa, position.coordinate.ordonna);
        this.direction = position.direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return  coordinate.toString() + ":" + direction.getDirectionSymbole() ;
    }

    public void incrementOrdonna() {
        coordinate.incrementOrdonna();
    }

    public void decrementOrdonna() {
        coordinate.decrementOrdonna();
    }

    public void incrementAbscissa() {
        coordinate.incrementAbscissa();
    }

    public void decrementAbscissa() {
        coordinate.decrementAbscissa();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position moveForward() {
        return direction.moveForward(this);
    }

    public Position moveBackward() {
        return direction.moveBackward(this);
    }

    public Position moveLeft() {
        return direction.moveLeft(this);
    }

    public Position moveRight() {
        return direction.moveRight(this);
    }
}
