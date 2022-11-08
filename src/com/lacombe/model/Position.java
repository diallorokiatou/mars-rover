package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;


public class Position {
    final Point point;

    final Direction direction;

    public Position(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

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
        return  direction.turnRight();
    }

    public Point getPoint() {
        return point;
    }

    public Direction getDirection() {
        return direction;
    }
}
