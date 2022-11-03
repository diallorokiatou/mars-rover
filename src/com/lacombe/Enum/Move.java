package src.com.lacombe.Enum;

import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

public enum Move {
    FORWARD('f'){
        @Override
        public Position executeCommand(Position position) {
            return position.moveForward();

        }
    },
    BACKWARD('b') {
        @Override
        public Position executeCommand(Position position) {
            return position.moveBackward();
        }
    },
    LEFT('l') {
        @Override
        public Position executeCommand(Position position) {
            return position.moveLeft();
        }
    },
    RIGHT('r') {
        @Override
        public Position executeCommand(Position position) {
            return position.moveRight();
        }
    };

    char moveSymbol;

    Move(char moveSymbol) {
        this.moveSymbol = moveSymbol;
    }

    public static Move getByChar(char moveSymbol){
        for (Move move : Move.values()) {
            if(move.moveSymbol == moveSymbol){
                return move;
            }
        }
        throw new InvalidParameterException("Invalid move char : " + moveSymbol);
    }

    public abstract Position executeCommand(Position position);
}
