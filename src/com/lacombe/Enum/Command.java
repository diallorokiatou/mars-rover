package src.com.lacombe.Enum;

import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'){
        @Override
        public Position execute(Position position, Grid grid) {
            return position.moveForward(grid);
        }
    },
    BACKWARD('b') {
        @Override
        public Position execute(Position position, Grid grid) {
            return position.moveBackward(grid);
        }
    },
    LEFT('l') {
        @Override
        public Position execute(Position position, Grid grid) {
            return new Position(position.point(), position.turnLeft());
        }
    },
    RIGHT('r') {
        @Override
        public Position execute(Position position, Grid grid) {
            return new Position(position.point(), position.turnRight());
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

    public abstract Position execute(Position position, Grid grid);
}
