package src.com.lacombe.Enum;

import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'){
        @Override
        public Position execute(Position position) {
            return new Position(position.moveForward(), position.getDirection());
        }
    },
    BACKWARD('b') {
        @Override
        public Position execute(Position position) {
            return new Position(position.moveBackward(), position.getDirection());
        }
    },
    LEFT('l') {
        @Override
        public Position execute(Position position) {
            return new Position(position.getPoint(), position.turnLeft());
        }
    },
    RIGHT('r') {
        @Override
        public Position execute(Position position) {
            return new Position(position.getPoint(), position.turnRight());
        }
    };

    final char commandChar;

    Command(char commandChar) {
        this.commandChar = commandChar;
    }

    public static Command getByChar(char commandChar){
        for (Command command : Command.values()) {
            if(command.commandChar == commandChar){
                return command;
            }
        }
        throw new InvalidParameterException("Invalid command char : " + commandChar);
    }

    public abstract Position execute(Position position);
}
