package src.com.lacombe.command;

import src.com.lacombe.Enum.Direction;
import src.com.lacombe.model.Commands;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Point;
import src.com.lacombe.model.Position;

public class Rover {
    Grid grid;
    Position position;

    public Rover(Point point, char direction, Grid grid) {
        this.grid = grid;
        if(grid.contains(point))
            throw new IllegalArgumentException("Point(x,y) must be in range [1," + grid.getWidth() + "]");
        this.position = new Position(point, Direction.getByChar(direction));
    }

    public void receive(char[] commandList) {
        if(commandList == null)
            throw new NullPointerException("commands can't be null");
        Commands commands = new Commands(commandList);
        position = commands.execute(position, grid);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
