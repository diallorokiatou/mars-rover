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

    public void execute(Position position){
        Move firstCommand = getFirstCommand();
        if(firstCommand == Move.FORWARD){
            position.moveForward();
            return;
        }
        if(firstCommand == Move.BACKWARD){
            position.moveBackward();
            return;
        }
        if(firstCommand == Move.LEFT){
            position.moveLeft();
            return;
        }
        position.moveRight();
    }

    public List<Move> getCommands() {
        return commands;
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
}
