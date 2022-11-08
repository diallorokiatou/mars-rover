package src.com.lacombe.model;

import src.com.lacombe.Enum.Command;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    List<Command> commands;

    public Commands(char[] commandCharArray) {
        commands = new ArrayList<>();
        for(char commandChar : commandCharArray){
             commands.add(Command.getByChar(commandChar));
        }
    }

    public Position execute(Position position, Grid grid){
        for (Command command : commands) {
            Position nextPosition = command.execute(position);
            if (grid.hasObstacleAt(nextPosition.point()))
                throw new RuntimeException("An obstacle is detected at position " + nextPosition.point() + "; The current position is " + position);
            position = nextPosition;
        }
        return position;
    }
}
