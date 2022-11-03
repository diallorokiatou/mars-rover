package src.com.lacombe.model;

import src.com.lacombe.Enum.Move;

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

    public Command(List<Move> commands) {
        this.commands = commands;
    }

    public void executeCommandOnPosition(Position position, Move move){
        move.executeCommand(position);
    }

    public Move getFirstCommand(){
       return commands.get(0);
    }
    public int size() {
        return commands.size();
    }

    public Command skip(int n) {
        return new Command(commands.stream().skip(n).toList());
    }

    public List<Move> getCommands() {
        return commands;
    }
}
