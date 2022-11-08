package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;


public record Position(Point point, Direction direction) {

    @Override
    public String toString() {
        return point + ":" + direction.toString();
    }

    public Point moveBackward() {
        return direction.moveBackward(point);
    }

    public Point moveForward() {
        return direction.moveForward(point);
    }

    public Direction turnLeft() {
        return direction.turnLeft();
    }

    public Direction turnRight() {
        return direction.turnRight();
    }
}
