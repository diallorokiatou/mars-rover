package src.com.lacombe.command;

import src.com.lacombe.Enum.Command;
import src.com.lacombe.model.Commands;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Point;
import src.com.lacombe.model.Position;

public class Rover {
    public Grid grid;
    Position position;

    public Rover(int x, int y, char direction, int capacity, Point ...obstacles) {
        position = new Position(x, y,direction, capacity);
        grid = new Grid(capacity, obstacles);
    }

    public void receive(char[] commandList) {
        if(commandList == null)
            throw new NullPointerException("commands can't be null");
        if(commandList.length < 1) return;
        Commands commands = new Commands(commandList);
        for(Command command : commands.getCommands()){
            command.execute(this.position, this.grid);
        }
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
