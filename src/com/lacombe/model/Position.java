package src.com.lacombe.model;

import src.com.lacombe.Enum.Direction;

public class Position {
    Point point;

    Direction direction;

    public Position(int x, int y,char direction, int capacity) {
        this.point = new Point(x, y, capacity);
        this.direction = Direction.getByChar(direction);
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

    public void moveBackward(Grid grid) {
        direction.moveBackward(point);
   }

    public void moveForward(Grid grid) {
        direction.moveForward(point);
    }

    public Point getPoint() {
        return point;
    }
}
