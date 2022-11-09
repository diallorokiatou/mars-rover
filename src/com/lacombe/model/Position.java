package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;


public record Position(Point point, Direction direction) {

    @Override
    public String toString() {
        return point + ":" + direction.toString();
    }

    public Position moveBackward(Grid grid) {
        return direction.moveBackward(point, grid);
    }

    public Position moveForward(Grid grid) {
        return direction.moveForward(point, grid);
    }

    public Direction turnLeft() {
        return direction.turnLeft();
    }

    public Direction turnRight() {
        return direction.turnRight();
    }
}
