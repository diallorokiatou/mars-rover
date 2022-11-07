package src.com.lacombe.Enum;

import java.security.InvalidParameterException;

public enum Direction {
    North('N'){
        @Override
        public Direction getLeft() {
            return Direction.West;
        }
    },
    South('S'){
        @Override
        public Direction getLeft() {
            return null;
        }
    },
    East('E') {
        @Override
        public Direction getLeft() {
            return null;
        }
    },
    West('W') {
        @Override
        public Direction getLeft() {
            return null;
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

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
