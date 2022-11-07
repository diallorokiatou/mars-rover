package src.com.lacombe.Enum;

import src.com.lacombe.command.Rover;
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
        public Point moveForward(Point point) {
            point.incrementY();
            return point;
        }

        @Override
        public Point moveBackward(Point point) {
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
        public Point moveForward(Point point) {
            String message = "; The current position is " + point.toString() + ":" + this.toString();
            point.decrementY();
            Rover.grid.hasObstacle(point, message);
            return point;

        }

        @Override
        public Point moveBackward(Point point) {
            point.incrementY();
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
        public Point moveForward(Point point) {
            point.incrementX();
            return point;
        }

        @Override
        public Point moveBackward(Point point) {
            point.decrementX();
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
        public Point moveForward(Point point) {
            point.decrementX();
            return point;
        }

        @Override
        public Point moveBackward(Point point) {
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

    public abstract Point moveForward(Point point);

    public abstract Point moveBackward(Point point);

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
