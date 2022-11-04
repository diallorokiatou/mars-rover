package src.com.lacombe.Enum;

import java.security.InvalidParameterException;

public enum Command {
    FORWARD('f'),
    BACKWARD('b'),
    LEFT('l'),
    RIGHT('r');

    char commandChar;

    Command(char commandChar) {
        this.commandChar = commandChar;
    }

    public static Command getByChar(char commandChar){
        for (Command command : Command.values()) {
            if(command.commandChar == commandChar){
                return command;
            }
        }
        throw new InvalidParameterException("Invalid command char : " + commandChar);
    }
}
