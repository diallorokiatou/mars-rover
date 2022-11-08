package src.com.lacombe.command;

import src.com.lacombe.Enum.Command;
import src.com.lacombe.Enum.Direction;
import src.com.lacombe.model.Commands;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Point;
import src.com.lacombe.model.Position;

public class Rover {
    public Grid grid;
    Position position;

    public Rover(int x, int y, char direction, Grid grid) {
        this.grid = grid;
        this.position = new Position(new Point(x, y, grid.getCapacity()), Direction.getByChar(direction));
    }

    public void receive(char[] commandList) {
        if(commandList == null)
            throw new NullPointerException("commands can't be null");
        Commands commands = new Commands(commandList);
        for(Command command : commands.getCommands()){
            Position currentPosition = position.clone();
            command.execute(this.position, this.grid);
            if(grid.hasObstacle(this.position.getPoint())){
                Position obstacle = position.clone();
                position = currentPosition;
                throw new RuntimeException("An obstacle is detected at position " +  obstacle.getPoint() + "; The current position is " + currentPosition);
            }

        }
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
