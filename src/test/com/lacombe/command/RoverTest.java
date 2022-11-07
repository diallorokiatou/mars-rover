package src.test.com.lacombe.command;

import org.junit.jupiter.api.Test;
import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RoverTestShould {

    @Test
    public void init_the_rover_starting_Rover() {
        Rover rover_starting_at_x_1_y_1_direction_E = new Rover(1,1, 'E');
        Rover rover_starting_at_x_1_y_2_direction_W = new Rover(1, 2, 'W');
        Rover rover_starting_at_x_2_y_1_direction_N = new Rover(2, 1, 'N');
        Rover rover_starting_at_x_1_y_1_direction_S = new Rover(1, 1, 'S');

        assertEquals("1:1:E", rover_starting_at_x_1_y_1_direction_E.toString());
        assertEquals("1:2:W", rover_starting_at_x_1_y_2_direction_W.toString());
        assertEquals("2:1:N", rover_starting_at_x_2_y_1_direction_N.toString());
        assertEquals("1:1:S", rover_starting_at_x_1_y_1_direction_S.toString());
    }

    @Test
    public void throw_illegal_argument_error_wen_commands_is_null() {
        Commands commands = null;

        Rover rover = new Rover(1, 1, 'E');

        Throwable exception = assertThrows(NullPointerException.class,
                () -> {rover.receive(commands);});

        assertEquals("1:1:E", rover.toString());
    }
    @Test
    public void not_move_when_commands_size_is_less_than_1() {
        char[] command = new char[]{};
        Commands commands = new Commands(command);

        Rover rover = new Rover(1, 1, 'E');
        rover.receive(commands);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
   public void move_forward_when_direction_is_East() {
        char[] command = new char[]{'f'};
        Commands commands = new Commands(command);

        Rover rover = new Rover(1, 1, 'E');
        rover.receive(commands);

        assertEquals("2:1:E", rover.toString());
    }

   @Test
    public void move_forward_when_direction_is_West() {
        char[] moves = new char[]{'f'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(2, 1, 'W');

        rover.receive(command);

        assertEquals("1:1:W", rover.toString());
    }

    @Test
    public void move_forward_when_direction_is_South() {
        char[] moves = new char[]{'f'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 2, 'S');

        rover.receive(command);

        assertEquals("1:1:S", rover.toString());
    }

    @Test
    public void move_forward_when_direction_is_North() {
        char[] moves = new char[]{'f'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'N');
        
        rover.receive(command);

        assertEquals("1:2:N", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_East() {
        char[] moves = new char[]{'b'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(2, 1, 'E');
        
        rover.receive(command);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_West() {
        char[] moves = new char[]{'b'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'W');
        
        rover.receive(command);

        assertEquals("2:1:W", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_South() {
        char[] moves = new char[]{'b'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'S');
        
        rover.receive(command);

        assertEquals("1:2:S", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_North() {
        char[] moves = new char[]{'b'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 2, 'N');
        
        rover.receive(command);

        assertEquals("1:1:N", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_East() {
        char[] moves = new char[]{'l'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'E');

        rover.receive(command);

        assertEquals("1:1:N", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_West() {
        char[] moves = new char[]{'l'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'W');

        rover.receive(command);

        assertEquals("1:1:S", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_South() {
        char[] moves = new char[]{'l'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'S');

        rover.receive(command);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_North() {
        char[] moves = new char[]{'l'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'N');

        rover.receive(command);

        assertEquals("1:1:W", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_East() {
        char[] moves = new char[]{'r'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'E');

        rover.receive(command);

        assertEquals("1:1:S", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_West() {
        char[] moves = new char[]{'r'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'W');

        rover.receive(command);

        assertEquals("1:1:N", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_South() {
        char[] moves = new char[]{'r'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'S');

        rover.receive(command);

        assertEquals("1:1:W", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_North() {
        char[] moves = new char[]{'r'};
        Commands command = new Commands(moves);
        Rover rover = new Rover(1, 1, 'N');

        rover.receive(command);

        assertEquals("1:1:E", rover.toString());
    }
}
