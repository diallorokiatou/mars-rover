package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;

public class Position{
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

    public void moveForward(){
        if(direction == Direction.East){
            coordinate.incrementAbscissa();
            return;
        }
        if(direction == Direction.West){
            coordinate.decrementAbscissa();
            return;
        }
        if(direction == Direction.North){
            coordinate.incrementOrdonna();
            return;
        }
        coordinate.decrementOrdonna();
    }

    public void moveBackward() {
        if(direction == Direction.East){
            coordinate.decrementAbscissa();
            return;
        }
        if(direction == Direction.West){
            coordinate.incrementAbscissa();
            return;
        }
        if(direction == Direction.North){
            coordinate.decrementOrdonna();
            return;
        }
        coordinate.incrementOrdonna();
    }

    public void moveLeft() {
        if(direction == Direction.East){
            this.direction = Direction.North;
            return;
        }
        if(direction == Direction.West){
            this.direction = Direction.South;
            return;
        }
        if(direction == Direction.North){
            this.direction = Direction.West;
            return;
        }
       this.direction = Direction.East;
    }

    public void moveRight() {
        if(direction == Direction.East){
            this.direction = Direction.South;
            return;
        }
        if(direction == Direction.West){
            this.direction = Direction.North;
            return;
        }
        if(direction == Direction.North){
            this.direction = Direction.East;
            return;
        }
        this.direction = Direction.West;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return  coordinate.toString() + ":" + direction.getDirectionSymbole() ;
    }

}
