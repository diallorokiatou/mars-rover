package src.com.lacombe.Enum;

import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'){
        @Override
        public void execute(Position position, Grid grid) {
            position.moveForward();
        }
    },
    BACKWARD('b') {
        @Override
        public void execute(Position position, Grid grid) {
            position.moveBackward();
        }
    },
    LEFT('l') {
        @Override
        public void execute(Position position, Grid grid) {
            position.turnLeft();
        }
    },
    RIGHT('r') {
        @Override
        public void execute(Position position, Grid grid) {
            position.turnRight();
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

    public abstract void execute(Position position, Grid grid);
}
