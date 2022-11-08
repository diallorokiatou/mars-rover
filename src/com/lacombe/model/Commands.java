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

    public List<Command> getCommands() {
        return commands;
    }
}
