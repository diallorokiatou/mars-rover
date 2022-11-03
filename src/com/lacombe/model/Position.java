package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;
import src.com.lacombe.command.IMove;

public class Position implements IMove {
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

    @Override
    public Position moveForward(Position position) {
        return direction.moveForward(this);
    }

    @Override
    public Position moveBackward(Position position) {
        return direction.moveBackward(this);
    }

    @Override
    public Position moveLeft(Position position) {
        return direction.moveLeft(this);
    }

    @Override
    public Position moveRight(Position position) {
        return direction.moveRight(this);
    }
}
