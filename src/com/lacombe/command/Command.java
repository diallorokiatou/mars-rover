package src.com.lacombe.command;

import src.com.lacombe.Enum.Move;
import src.com.lacombe.model.Coordinate;
import src.com.lacombe.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Command {

    List<Move> commands;

    public Command(char[] commandCharArray) {
        commands = new ArrayList<>();
        for(char commandChar : commandCharArray){
             commands.add(Move.getByChar(commandChar));
        }
    }

    public List<Move> getCommands() {
        return commands;
    }
}
