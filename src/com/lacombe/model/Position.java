package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;


public record Position(Point point, Direction direction) {

    @Override
    public String toString() {
        return point + ":" + direction.toString();
    }

    public Position moveBackward() {
        return direction.moveBackward(point);
    }

    public Position moveForward() {
        return direction.moveForward(point);
    }

    public Direction turnLeft() {
        return direction.turnLeft();
    }

    public Direction turnRight() {
        return direction.turnRight();
    }
}
