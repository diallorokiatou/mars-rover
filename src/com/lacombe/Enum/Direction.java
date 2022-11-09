package src.com.lacombe.Enum;

import src.com.lacombe.model.Point;

public enum Direction {
    North('N'){
        @Override
        public Direction turnLeft() {
            return Direction.West;
        }

        @Override
        public Direction turnRight() {
            return Direction.East;
        }

        @Override
        public Point moveForward(Point point) {
            return point.incrementY(1);
        }

        @Override
        public Point moveBackward(Point point) {
            return point.incrementY(-1);
        }
    },
    South('S'){
        @Override
        public Direction turnLeft() {
            return Direction.East;
        }

        @Override
        public Direction turnRight() {
            return Direction.West;
        }

        @Override
        public Point moveForward(Point point) {
            return point.incrementY(-1);
        }

        @Override
        public Point moveBackward(Point point) {
            return point.incrementY(1);
        }
    },
    East('E') {
        @Override
        public Direction turnLeft() {
            return Direction.North;
        }

        @Override
        public Direction turnRight() {
            return Direction.South;
        }

        @Override
        public Point moveForward(Point point) {
            return point.incrementX(1);
        }

        @Override
        public Point moveBackward(Point point) {
            return point.incrementX(-1);
        }
    },
    West('W') {
        @Override
        public Direction turnLeft() {
            return Direction.South;
        }

        @Override
        public Direction turnRight() {
            return Direction.North;
        }

        @Override
        public Point moveForward(Point point) {
            return point.incrementX(-1);
        }

        @Override
        public Point moveBackward(Point point) {
            return point.incrementX(1);
        }
    };

    final char directionChar;

    Direction(char directionChar) {
        this.directionChar = directionChar;
    }

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    public abstract Point moveForward(Point point);

    public abstract Point moveBackward(Point point);

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
