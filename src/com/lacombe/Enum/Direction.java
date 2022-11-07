package src.com.lacombe.Enum;

import src.com.lacombe.model.Point;

import java.security.InvalidParameterException;

public enum Direction {
    North('N'){
        @Override
        public Direction getLeft() {
            return Direction.West;
        }

        @Override
        public Direction getRight() {
            return Direction.East;
        }

        @Override
        public Point getForward(Point point) {
            point.incrementY();
            return point;
        }

        @Override
        public Point getBackward(Point point) {
            point.decrementY();
            return point;
        }
    },
    South('S'){
        @Override
        public Direction getLeft() {
            return Direction.East;
        }

        @Override
        public Direction getRight() {
            return Direction.West;
        }

        @Override
        public Point getForward(Point point) {
            point.decrementY();
            return point;
        }

        @Override
        public Point getBackward(Point point) {
            point.incrementY();
            return point;
        }
    },
    East('E') {
        @Override
        public Direction getLeft() {
            return Direction.North;
        }

        @Override
        public Direction getRight() {
            return Direction.South;
        }

        @Override
        public Point getForward(Point point) {
            point.incrementX();
            return point;
        }

        @Override
        public Point getBackward(Point point) {
            point.decrementX();
            return point;
        }
    },
    West('W') {
        @Override
        public Direction getLeft() {
            return Direction.South;
        }

        @Override
        public Direction getRight() {
            return Direction.North;
        }

        @Override
        public Point getForward(Point point) {
            point.decrementX();
            return point;
        }

        @Override
        public Point getBackward(Point point) {
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

    public abstract Direction getLeft();

    public abstract Direction getRight();

    public abstract Point getForward(Point point);

    public abstract Point getBackward(Point point);

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
