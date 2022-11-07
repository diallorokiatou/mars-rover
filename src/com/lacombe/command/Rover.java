package src.com.lacombe.command;

import src.com.lacombe.Enum.Command;
import src.com.lacombe.model.Commands;
import src.com.lacombe.model.Point;
import src.com.lacombe.model.Position;

public class Rover {
    public static Point obstacle;
    Position position;

    public Rover(int x, int y, char direction, int capacity) {
        position = new Position(x, y,direction, capacity);
        obstacle = new Point(2,4,capacity);
    }

    public void receive(Commands commands) {
        if(commands == null)
            throw new NullPointerException("commands can't be null");
        if(commands.size() < 1) return;
        for(Command command : commands.getCommands()){
            command.execute(this.position);
        }
    }


    @Override
    public String toString() {
        return position.toString();
    }
}
