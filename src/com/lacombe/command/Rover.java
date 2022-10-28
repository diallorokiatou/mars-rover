package src.com.lacombe.command;

import src.com.lacombe.Enum.Direction;
import src.com.lacombe.Enum.Move;
import src.com.lacombe.model.Coordinate;
import src.com.lacombe.model.Position;

public class Rover {

    public void move(Position startingPosition, Command command) {
        for (Move move: command.getCommands()) {
            switch (move) {
                case FORWARD:
                    startingPosition.moveForward();
                    break;

            }
        }
    }

}
