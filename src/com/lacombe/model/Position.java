package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;

public class Position{
    Coordinate coordinate;
    Direction direction;

    public Position(int abscissa, int ordonna, char direction) {
        this.coordinate = new Coordinate(abscissa, ordonna);
        this.direction = Direction.getByChar(direction);
    }

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Position moveForward(){
        if(direction == Direction.East)
            coordinate.incrementOrdonna();
        if(direction == Direction.West)
            coordinate.decrementOrdonna();
        if(direction == Direction.North)
            coordinate.incrementAbscissa();
        if(direction == Direction.South)
            coordinate.decrementAbscissa();
        return this;
    }

    public Position moveBackward() {
        if(direction == Direction.East)
            coordinate.decrementOrdonna();
        if(direction == Direction.West)
            coordinate.incrementOrdonna();
        if(direction == Direction.North)
            coordinate.decrementAbscissa();
        if(direction == Direction.South)
            coordinate.incrementAbscissa();
        return this;
    }

    public Position moveLeft() {
        if(direction == Direction.East)
            return new Position(coordinate, Direction.North);
        if(direction == Direction.West)
            return new Position(coordinate, Direction.South);
        if(direction == Direction.North)
            return new Position(coordinate, Direction.West);
        return new Position(coordinate, Direction.East);
    }

    public Position moveRight() {
        if(direction == Direction.East)
            return new Position(coordinate, Direction.South);
        if(direction == Direction.West)
            return new Position(coordinate, Direction.North);
        if(direction == Direction.North)
            return new Position(coordinate, Direction.East);
        return new Position(coordinate, Direction.West);
    }

    @Override
    public String toString() {
        return  coordinate.toString() + ":" + direction.getDirectionSymbole() ;
    }
}
