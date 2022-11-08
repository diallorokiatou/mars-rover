package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;


public class Position implements Cloneable {
    final Point point;

    Direction direction;

    public Position(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void turnLeft(){
        direction = direction.turnLeft();
    }

    public void turnRight(){
        direction = direction.turnRight();
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

    @Override
    public Position clone() {
        return new Position(point.clone(), direction);
    }
}
