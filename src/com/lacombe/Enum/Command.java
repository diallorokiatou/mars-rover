package src.com.lacombe.Enum;

import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Point;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'){
        @Override
        public Rover execute(Point point, Direction direction) {
            point = direction.moveForward(point);
            return new Rover(point, direction);
        }
    },
    BACKWARD('b') {
        @Override
        public Rover execute(Point point, Direction direction) {
            point = direction.moveBackward(point);
            return new Rover(point, direction);
        }
    },
    LEFT('l') {
        @Override
        public Rover execute(Point point, Direction direction) {
            return new Rover(point, direction.turnLeft());
        }
    },
    RIGHT('r') {
        @Override
        public Rover execute(Point point, Direction direction) {
            return new Rover(point, direction.turnRight());
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

    public abstract Rover execute(Point point, Direction direction);
}
