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
        String currentPositionMessage = "; The current position is " + this.toString();
        direction.moveBackward(point);
        if(grid.hasObstacle(point))
            throw new RuntimeException("An obstacle is detected at position " +  point.toString() + currentPositionMessage);
    }

    public void moveForward(Grid grid) {
        String currentPositionMessage = "; The current position is " + this.toString();
        direction.moveForward(point);
        if(grid.hasObstacle(point))
            throw new RuntimeException("An obstacle is detected at position " +  point.toString() + currentPositionMessage);
    }

}
