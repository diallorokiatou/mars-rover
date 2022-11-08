package src.com.lacombe.Enum;

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
        public void moveForward(Point point) {
            point.incrementY();
        }

        @Override
        public void moveBackward(Point point) {
            point.decrementY();
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
        public void moveForward(Point point) {
            point.decrementY();
        }

        @Override
        public void moveBackward(Point point) {
            point.incrementY();
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
        public void moveForward(Point point) {
            point.incrementX();

        }

        @Override
        public void moveBackward(Point point) {
            point.decrementX();
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
        public void moveForward(Point point) {
            point.decrementX();

        }

        @Override
        public void moveBackward(Point point) {
            point.incrementX();
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

    public abstract void moveForward(Point point);

    public abstract void moveBackward(Point point);

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
