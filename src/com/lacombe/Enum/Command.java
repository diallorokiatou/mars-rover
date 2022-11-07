package src.com.lacombe.Enum;

import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Point;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'){
        @Override
        public Rover execute(Point point, Direction direction) {
            if(direction == Direction.North){
                point.incrementY();
                return new Rover(point, direction);
            }
            if(direction == Direction.South){
                point.decrementY();
                return new Rover(point, direction);
            }
            if(direction == Direction.East){
                point.incrementX();
                return new Rover(point, direction);
            }
            point.decrementX();
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
            if(direction == Direction.North){
                return new Rover(point, direction.getLeft());
            }
            if(direction == Direction.South){
                direction = Direction.East;
                return new Rover(point, direction);
            }
            if(direction == Direction.East){
                direction = Direction.North;
                return new Rover(point, direction);
            }
            direction = Direction.South;
            return new Rover(point, direction);
        }
    },
    RIGHT('r') {
        @Override
        public Rover execute(Point point, Direction direction) {
            if(direction == Direction.North){
                direction = Direction.East;
                return new Rover(point, direction);
            }
            if(direction == Direction.South){
                direction = Direction.West;
                return new Rover(point, direction);
            }
            if(direction == Direction.East){
                direction = Direction.South;
                return new Rover(point, direction);
            }
            direction = Direction.North;
            return new Rover(point, direction);
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
