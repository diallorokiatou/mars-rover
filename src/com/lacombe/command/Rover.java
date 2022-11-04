package src.com.lacombe.command;

import src.com.lacombe.Enum.Command;
import src.com.lacombe.Enum.Direction;
import src.com.lacombe.model.Commands;
import src.com.lacombe.model.Point;

public class Rover {
    Point point;

    Direction direction;

    public Rover(int x, int y, char direction) {
        this.point = new Point(x, y);
        this.direction = Direction.getByChar(direction);
    }

    public void move(Commands commands) {
        if(commands == null)
            throw new NullPointerException("commands can't be null");
        if(commands.size() < 1) return;
        for(Command command : commands.getCommands()){
            if(command == Command.FORWARD){
                if(direction == Direction.North){
                    point.incrementY();
                }
                if(direction == Direction.South){
                    point.decrementY();
                }
                if(direction == Direction.East){
                    point.incrementX();
                }
                if(direction == Direction.West){
                    point.decrementX();
                }
            }
            if(command == Command.BACKWARD){
                if(direction == Direction.North){
                    point.decrementY();
                }
                if(direction == Direction.South){
                    point.incrementY();
                }
                if(direction == Direction.East){
                    point.decrementX();
                }
                if(direction == Direction.West){
                    point.incrementX();
                }
            }
        }

    }

    @Override
    public String toString() {
        return point + ":" + direction.toString();
    }
}
