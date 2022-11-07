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

    public Rover(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void receive(Commands commands) {
        if(commands == null)
            throw new NullPointerException("commands can't be null");
        if(commands.size() < 1) return;
        for(Command command : commands.getCommands()){
            Rover rover = command.execute(point, direction);
            setRover(rover);
        }
    }

    private void setRover(Rover rover) {
        this.point = rover.point;
        this.direction = rover.direction;
    }

    @Override
    public String toString() {
        return point + ":" + direction.toString();
    }
}
