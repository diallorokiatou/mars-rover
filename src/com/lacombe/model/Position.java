package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;

public class Position {
    Point point;

    Direction direction;

    public Position(int x, int y,char direction, int capacity) {
        this.point = new Point(x, y, capacity);
        this.direction = Direction.getByChar(direction);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
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
}
