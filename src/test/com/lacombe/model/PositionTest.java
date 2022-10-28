package src.test.com.lacombe.model;

import org.junit.jupiter.api.Test;
import src.com.lacombe.Enum.Direction;
import src.com.lacombe.command.Command;
import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class PositionTestShould {

    @Test
    public void show_position_of_the_rover(){
        Position position = new Position(2,3, 'N');

        assertEquals("2:3:N", position.toString());
    }

    @Test
    public void throws_error_when_invalid_position_is_set(){
        Throwable exception = assertThrows(InvalidParameterException.class,
                ()->{new Position(2,3, 'B');} );
    }

}