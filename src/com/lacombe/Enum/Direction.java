package src.com.lacombe.Enum;

import java.security.InvalidParameterException;

public enum Direction {
    North('N'),
    South('S'),
    East('E'),
    West('W');

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

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
