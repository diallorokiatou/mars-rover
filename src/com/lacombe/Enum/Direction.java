package src.com.lacombe.Enum;

import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

public enum Direction {
    North('N'){
        @Override
        public Position moveForward(Position position) {
            position.incrementOrdonna();
            return position;
        }

        @Override
        public Position moveBackward(Position position) {
            position.decrementOrdonna();
            return position;
        }

        @Override
        public Position moveLeft(Position position) {
            position.setDirection(Direction.West);
            return position;
        }

        @Override
        public Position moveRight(Position position) {
            position.setDirection(Direction.East);
            return position;
        }
    },
    South('S'){
        @Override
        public Position moveForward(Position position) {
            position.decrementOrdonna();
            return position;
        }

        @Override
        public Position moveBackward(Position position) {
            position.incrementOrdonna();
            return position;
        }

        @Override
        public Position moveLeft(Position position) {
            position.setDirection(Direction.East);
            return position;
        }

        @Override
        public Position moveRight(Position position) {
            position.setDirection(Direction.West);
            return position;
        }
    },
    East('E'){
        @Override
        public Position moveForward(Position position) {
            position.incrementAbscissa();
            return position;
        }

        @Override
        public Position moveBackward(Position position) {
            position.decrementAbscissa();
            return position;
        }

        @Override
        public Position moveLeft(Position position) {
            position.setDirection(Direction.North);
            return position;
        }

        @Override
        public Position moveRight(Position position) {
            position.setDirection(Direction.South);
            return position;
        }
    },
    West('W'){
        @Override
        public Position moveForward(Position position) {
            position.decrementAbscissa();
            return position;
        }

        @Override
        public Position moveBackward(Position position) {
            position.incrementAbscissa();
            return position;
        }

        @Override
        public Position moveLeft(Position position) {
            position.setDirection(Direction.South);
            return position;
        }

        @Override
        public Position moveRight(Position position) {
            position.setDirection(Direction.North);
            return position;
        }
    }
    ;

    char directionSymbole;

    Direction(char directionSymbole) {
        this.directionSymbole = directionSymbole;
    }

    public static Direction getByChar(char directionSymbol){
        for (Direction direction : Direction.values()) {
            if(direction.directionSymbole == directionSymbol){
                return direction;
            }
        }
        throw new InvalidParameterException("Invalid direction char : " + directionSymbol);
    }

    public char getDirectionSymbole() {
        return directionSymbole;
    }

    public abstract Position moveForward(Position position);
    public abstract Position moveBackward(Position position);
    public abstract Position moveLeft(Position position);
    public abstract Position moveRight(Position position);

}
