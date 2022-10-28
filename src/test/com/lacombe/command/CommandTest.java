package src.test.com.lacombe.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import src.com.lacombe.Enum.Direction;
import src.com.lacombe.command.Command;
import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Position;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class CommandTestShould {

    @Test
    public void init_the_rover_starting_position(){
        Position rover_starting_position_abscissa_0_ordinate_0_direction_E = new Position(0,0, 'E');
        Position rover_starting_position_abscissa_0_ordinate_1_direction_W = new Position(0,1, 'W');
        Position rover_starting_position_abscissa_1_ordinate_0_direction_N = new Position(1,0, 'N');
        Position rover_starting_position_abscissa_1_ordinate_1_direction_S = new Position(1,1, 'S');

        assertEquals("0:0:E", rover_starting_position_abscissa_0_ordinate_0_direction_E.toString());
        assertEquals("0:1:W", rover_starting_position_abscissa_0_ordinate_1_direction_W.toString());
        assertEquals("1:0:N", rover_starting_position_abscissa_1_ordinate_0_direction_N.toString());
        assertEquals("1:1:S", rover_starting_position_abscissa_1_ordinate_1_direction_S.toString());

    }

    @Test
    public void throw_an_error_when_invalid_char_is_add(){
        char[] moves = new char[]{'a'};

        Throwable exception = assertThrows(InvalidParameterException.class,
                ()->{new Command(moves);} );
    }

    @Test
    public void receive_an_array_of_valid_character(){
        char[] moves = new char[]{'f', 'b', 'l', 'r'};

        assertDoesNotThrow(() -> new Command(moves));
    }

    @Test
    public void move_forward_the_rover(){
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(0,0,'E');

        Rover rover = new Rover();
        rover.move(position, command);


    }


}
