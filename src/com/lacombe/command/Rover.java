package src.com.lacombe.command;

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
        if(position == null || commands.size()  < 1)
            return;
        setCurrentPosition(new Position(position));
        commands.execute(position);
        checkIfPositionIsOutOfEdgeOrThereIsAnObastacleOnIt(position);
        setCurrentPosition(position);
        move(currentPosition, commands.skip(1));
    }

    private void checkIfPositionIsOutOfEdgeOrThereIsAnObastacleOnIt(Position position) {
        if(grid.getCellByHisCoordinate(position.getCoordinate()) == null)
            throw new NullPointerException("You are try to go out of the board : " + position + "; current position is " + currentPosition);
        if(grid.hasObstacle(position.getCoordinate()))
            throw new RuntimeException("An obstacle is detected in position " + position + "; current position is " + currentPosition);
    }

    public String getCurrentPosition() {
        return currentPosition.toString();
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

}
