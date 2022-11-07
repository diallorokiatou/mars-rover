package src.com.lacombe.Enum;

import src.com.lacombe.model.Point;
import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'){
        @Override
        public Position execute(Position position) {
            Point point = position.getDirection().moveForward(position.getPoint());
            position.setPoint(point);
            return position;
        }
    },
    BACKWARD('b') {
        @Override
        public Position execute(Position position) {
            Point point = position.getDirection()
                    .moveBackward(position.getPoint());
            position.setPoint(point);
            return position;
        }
    },
    LEFT('l') {
        @Override
        public Position execute(Position position) {
            position.setDirection(position.getDirection()
                    .turnLeft());
            return position;
        }
    },
    RIGHT('r') {
        @Override
        public Position execute(Position position) {
            position.setDirection(position.getDirection()
                    .turnRight());
            return position;
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
