package src.com.lacombe.Enum;

import java.security.InvalidParameterException;

public enum Move {
    FORWARD('f'),
    BACKWARD('b'),
    LEFT('l'),
    RIGHT('r');

    char moveSymbol;

    Move(char moveSymbol) {
        this.moveSymbol = moveSymbol;
    }

    public char getMoveSymbol() {
        return moveSymbol;
    }

    public static Move getByChar(char moveSymbol){
        for (Move move : Move.values()) {
            if(move.moveSymbol == moveSymbol){
                return move;
            }
        }
        throw new InvalidParameterException("Invalid move char : " + moveSymbol);
    }
}
