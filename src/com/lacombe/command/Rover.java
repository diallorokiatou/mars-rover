package src.com.lacombe.command;

import src.com.lacombe.Enum.Move;
import src.com.lacombe.model.Command;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Position;

public class Rover {
    Position currentPosition;
    Grid grid;

    public  Rover(Grid grid){
        this.grid = grid;
    }

    public void move(Position position, Command commands) {
        if(commands == null ||commands.size()  < 1)
            throw new IllegalArgumentException("The commands must be initialize and must contains at least one Move");
        setCurrentPosition(position);
        for (Move move: commands.getCommands()) {
           setCurrentPosition(commands.executeCommandOnPosition(position,move));
        }
    }

    private void checkIfPositionIsOutOfEdgeOrThereIsAnObastacleOnIt(Position position) {
        if(position == null)
            throw new IllegalArgumentException("The starting position is null");
        if(grid.getCellByHisCoordinate(position.getCoordinate()) == null)
            throw new NullPointerException("You are try to go out of the board : " + position + "; current position is " + currentPosition);
        if(grid.hasObstacle(position.getCoordinate()))
            throw new RuntimeException("An obstacle is detected in position " + position + "; current position is " + currentPosition);
    }

    public String getCurrentPosition() {
        return currentPosition.toString();
    }

    public void setCurrentPosition(Position currentPosition) {
        checkIfPositionIsOutOfEdgeOrThereIsAnObastacleOnIt(currentPosition);
        this.currentPosition = new Position(currentPosition);
    }

}
