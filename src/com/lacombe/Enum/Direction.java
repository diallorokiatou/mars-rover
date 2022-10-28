package src.com.lacombe.Enum;

import java.security.InvalidParameterException;

public enum Direction {
    North('N'),
    South('S'),
    East('E'),
    West('W')
    ;

    char directionSymbole;

    Direction(char directionSymbole) {
        this.directionSymbole = directionSymbole;
    }

    public char getDirectionSymbole() {
        return directionSymbole;
    }

    public static Direction getByChar(char directionSymbol){
        for (Direction direction : Direction.values()) {
            if(direction.directionSymbole == directionSymbol){
                return direction;
            }
        }
        throw new InvalidParameterException("Invalid direction char : " + directionSymbol);
    }
}
