package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;


public class Position implements Cloneable {
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

    public void moveBackward() {
        direction.moveBackward(point);
   }

    public void moveForward() {
        direction.moveForward(point);
    }

    public Point getPoint() {
        return point;
    }

    public Direction getDirection() {
        return direction;
    }
    @Override
    public Position clone() {
        return new Position(point.clone(), direction);
    }
}
