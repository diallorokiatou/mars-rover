package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;


public record Position(Point point, Direction direction) {

    @Override
    public String toString() {
        return point + ":" + direction.toString();
    }

    public Position moveBackward() {
        return new Position(direction.moveBackward(point), direction);
    }

    public Position moveForward() {
        return new Position(direction.moveForward(point), direction);
    }

    public Direction turnLeft() {
        return direction.turnLeft();
    }

    public Direction turnRight() {
        return direction.turnRight();
    }
}
