package src.test.com.lacombe.command;

import org.junit.jupiter.api.Test;
import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Command;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTestShould {

    @Test
    public void init_the_rover_starting_position() {
        Position rover_starting_position_abscissa_0_ordinate_0_direction_E = new Position(0, 0, 'E');
        Position rover_starting_position_abscissa_0_ordinate_1_direction_W = new Position(0, 1, 'W');
        Position rover_starting_position_abscissa_1_ordinate_0_direction_N = new Position(1, 0, 'N');
        Position rover_starting_position_abscissa_1_ordinate_1_direction_S = new Position(1, 1, 'S');

        assertEquals("0:0:E", rover_starting_position_abscissa_0_ordinate_0_direction_E.toString());
        assertEquals("0:1:W", rover_starting_position_abscissa_0_ordinate_1_direction_W.toString());
        assertEquals("1:0:N", rover_starting_position_abscissa_1_ordinate_0_direction_N.toString());
        assertEquals("1:1:S", rover_starting_position_abscissa_1_ordinate_1_direction_S.toString());

    }

    @Test
    public void move_forward_when_direction_is_East() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'E');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:2:E", rover.getCurrentPosition());
    }

    @Test
    public void move_forward_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:0:W", rover.getCurrentPosition());
    }

    @Test
    public void move_forward_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("0:1:S", rover.getCurrentPosition());
    }

    @Test
    public void move_forward_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("2:1:N", rover.getCurrentPosition());
    }

    @Test
    public void move_when_direction_is_East() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'E');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:0:E", rover.getCurrentPosition());
    }

    @Test
    public void move_backward_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:2:W", rover.getCurrentPosition());
    }

    @Test
    public void move_backward_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("2:1:S", rover.getCurrentPosition());
    }

    @Test
    public void move_backward_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("0:1:N", rover.getCurrentPosition());
    }

    @Test
    public void move_left_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'l'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:1:S", rover.getCurrentPosition());
    }

    @Test
    public void move_left_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'l'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:1:E", rover.getCurrentPosition());
    }

    @Test
    public void move_left_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'l'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:1:W", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_East() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'E');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:1:S", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:1:N", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:1:W", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("1:1:E", rover.getCurrentPosition());
    }

    @Test
    public void move_right_backward_left_forward_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r', 'b', 'l', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("2:0:N", rover.getCurrentPosition());
    }

    @Test
    public void move_right_backward_left_forward_when_direction_is_North_the_rover() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r', 'b', 'l', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover();
        rover.move(grid, position, command);

        assertEquals("2:0:N", rover.getCurrentPosition());
    }

    @Test
    public void throw_error_when_starting_point_is_out_of_the_grid() {
        Grid grid = new Grid(2);
        char[] moves = new char[]{'f', 'f', 'f'};
        Command command = new Command(moves);
        Position position = new Position(3, 2, 'N');

        Rover rover = new Rover();

        Throwable exception = assertThrows(NullPointerException.class,
                () -> {rover.move(grid, position, command);});
    }

    @Test
    public void throw_error_when_rover_try_to_cross_edges_and_position_is_the_last_possible_move() {
        Grid grid = new Grid(2);
        char[] moves = new char[]{'f', 'f', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover();

        Throwable exception = assertThrows(NullPointerException.class,
                () -> {rover.move(grid, position, command);});
        assertEquals("2:1:N", rover.getCurrentPosition());
    }

}
