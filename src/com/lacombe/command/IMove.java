package src.com.lacombe.command;

import src.com.lacombe.model.Position;

public interface IMove {
    public  Position moveForward(Position position);
    public  Position moveBackward(Position position);
    public  Position moveLeft(Position position);
    public  Position moveRight(Position position);
}
