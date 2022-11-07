package src.com.lacombe.command;

import src.com.lacombe.Enum.Command;
import src.com.lacombe.model.Commands;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Point;
import src.com.lacombe.model.Position;

import java.util.List;

public class Rover {
    public Grid grid;
    Position position;

    public Rover(int x, int y, char direction, int capacity) {
        position = new Position(x, y,direction, capacity);
        List obstacles = List.of(new Point(2, 4, capacity), new Point(3, 2, capacity));
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
