package src.com.lacombe.Enum;

import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Point;
import src.com.lacombe.model.Position;

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
        public Position moveForward(Point point, Grid grid) {
            return new Position(grid.incrementY(point,1), this);
        }

        @Override
        public Position moveBackward(Point point, Grid grid) {
            return new Position(grid.incrementY(point,-1), this);
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
        public Position moveForward(Point point, Grid grid) {
            return new Position(grid.incrementY(point,-1), this);
        }

        @Override
        public Position moveBackward(Point point, Grid grid) {
            return new Position(grid.incrementY(point,1), this);
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
        public Position moveForward(Point point, Grid grid) {
            return new Position(grid.incrementX(point, 1), this);

        }

        @Override
        public Position moveBackward(Point point, Grid grid) {
            return new Position(grid.incrementX(point,-1), this);
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
        public Position moveForward(Point point, Grid grid) {
            return new Position(grid.incrementX(point,-1), this);
        }

        @Override
        public Position moveBackward(Point point, Grid grid) {
            return new Position(grid.incrementX(point,1), this);
        }
    };

    final char directionChar;

    Direction(char directionChar) {
        this.directionChar = directionChar;
    }

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    public abstract Position moveForward(Point point, Grid grid);

    public abstract Position moveBackward(Point point, Grid grid);

    @Override
    public String toString() {
        return "" + directionChar;
    }
}
