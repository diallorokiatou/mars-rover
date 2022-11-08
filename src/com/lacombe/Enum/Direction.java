package src.com.lacombe.Enum;

import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Point;

import java.security.InvalidParameterException;

public enum Direction {
    North('N'){
        @Override
        public Direction turnLeft() {
            return Direction.West;
        }

        @Override
        public Direction turnRight() {
            return Direction.East;
        }

        @Override
        public Point moveForward(Point point, Grid grid) {
            point.incrementY();
            return point;
        }

        @Override
        public Point moveBackward(Point point, Grid grid) {
            point.decrementY();
            return point;
        }
    },
    South('S'){
        @Override
        public Direction turnLeft() {
            return Direction.East;
        }

        @Override
        public Direction turnRight() {
            return Direction.West;
        }

        @Override
        public Point moveForward(Point point, Grid grid) {
            String message = "; The current position is " + point + ":" + this;
            point.decrementY();
            if(grid.hasObstacle(point, message)) return null;
            return point;

        }

        @Override
        public Point moveBackward(Point point, Grid grid) {
            String message = "; The current position is " + point + ":" + this;
            point.incrementY();
            if(grid.hasObstacle(point, message)) return null;
            return point;
        }
    },
    East('E') {
        @Override
        public Direction turnLeft() {
            return Direction.North;
        }

        @Override
        public Direction turnRight() {
            return Direction.South;
        }

        @Override
        public Point moveForward(Point point, Grid grid) {
            String message = "; The current position is " + point + ":" + this;
            point.incrementX();
            if(grid.hasObstacle(point, message)) return null;
            return point;
        }

        @Override
        public Point moveBackward(Point point, Grid grid) {
            String message = "; The current position is " + point + ":" + this;
            point.decrementX();
            if(grid.hasObstacle(point, message)) return null;
            return point;
        }
    },
    West('W') {
        @Override
        public Direction turnLeft() {
            return Direction.South;
        }

        @Override
        public Direction turnRight() {
            return Direction.North;
        }

        @Override
        public Point moveForward(Point point, Grid grid) {
            point.decrementX();
            return point;
        }

        @Override
        public Point moveBackward(Point point, Grid grid) {
            point.incrementX();
            return point;
        }
    };

    final char directionChar;

    Direction(char directionChar) {
        this.directionChar = directionChar;
    }

    public static Direction getByChar(char directionChar){
        for (Direction direction : Direction.values()) {
            if(direction.directionChar == directionChar)
                return direction;
        }
        throw new InvalidParameterException("Invalid direction char : " + directionChar);
    }

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    public abstract Point moveForward(Point point, Grid grid);

    public abstract Point moveBackward(Point point, Grid grid);

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
