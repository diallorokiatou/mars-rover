package src.com.lacombe.command;

import src.com.lacombe.Enum.Move;
import src.com.lacombe.model.Command;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Position;

public class Rover {
    Position currentPosition;

    public void move(Grid grid, Position startingPosition, Command command) {
        if(startingPosition == null || grid.getCellByHisCoordinate(startingPosition) == null)
            throw new NullPointerException("You are try to go out of the board : " + startingPosition);
        if(command.size()  < 1)
            return;
        currentPosition = getMove(startingPosition, command.getMove(0));
        move(grid, currentPosition, command.skip(1));
    }

    public Position getMove(Position position, Move move){
        if(move == Move.FORWARD)
            return position.moveForward();
        if(move == Move.BACKWARD)
                return position.moveBackward();
        if(move == Move.LEFT)
                return position.moveLeft();
        return position.moveRight();
    }

    public String getCurrentPosition() {
        return currentPosition.toString();
    }

}
