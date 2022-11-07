package src.com.lacombe.Enum;

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

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
