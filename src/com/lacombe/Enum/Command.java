package src.com.lacombe.Enum;

import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Point;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'){
        @Override
        public Rover execute(Point point, Direction direction) {
            point = direction.getForward(point);
            return new Rover(point, direction);
        }
    },
    BACKWARD('b') {
        @Override
        public Rover execute(Point point, Direction direction) {
            if(direction == Direction.North){
                point.decrementY();
                return new Rover(point, direction);
            }
            if(direction == Direction.South){
                point.incrementY();
                return new Rover(point, direction);
            }
            if(direction == Direction.East){
                point.decrementX();
                return new Rover(point, direction);
            }
            point.incrementX();
            return new Rover(point, direction);
        }
    },
    LEFT('l') {
        @Override
        public Rover execute(Point point, Direction direction) {
            return new Rover(point, direction.getLeft());
        }
    },
    RIGHT('r') {
        @Override
        public Rover execute(Point point, Direction direction) {
            return new Rover(point, direction.getRight());
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
