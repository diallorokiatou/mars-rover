package src.test.com.lacombe.command;

import org.junit.jupiter.api.Test;
import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Command;
import src.com.lacombe.model.Coordinate;
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

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("2:1:E", rover.getCurrentPosition());
    }

    @Test
    public void move_forward_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("0:1:W", rover.getCurrentPosition());
    }

    @Test
    public void move_forward_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:0:S", rover.getCurrentPosition());
    }

    @Test
    public void move_forward_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:2:N", rover.getCurrentPosition());
    }

    @Test
    public void move_backward_when_direction_is_East() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'E');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("0:1:E", rover.getCurrentPosition());
    }

    @Test
    public void move_backward_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("2:1:W", rover.getCurrentPosition());
    }

    @Test
    public void move_backward_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:2:S", rover.getCurrentPosition());
    }

    @Test
    public void move_backward_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'b'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:0:N", rover.getCurrentPosition());
    }

    @Test
    public void move_left_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'l'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:1:S", rover.getCurrentPosition());
    }

    @Test
    public void move_left_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'l'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:1:E", rover.getCurrentPosition());
    }

    @Test
    public void move_left_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'l'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:1:W", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_East() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'E');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:1:S", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_West() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'W');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:1:N", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_South() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'S');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:1:W", rover.getCurrentPosition());
    }

    @Test
    public void move_right_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("1:1:E", rover.getCurrentPosition());
    }

    @Test
    public void move_right_backward_left_forward_when_direction_is_North() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r', 'b', 'l', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("0:2:N", rover.getCurrentPosition());
    }

    @Test
    public void move_right_backward_left_forward_when_direction_is_North_the_rover() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'r', 'b', 'l', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover(grid);
        rover.move(position, command);

        assertEquals("0:2:N", rover.getCurrentPosition());
    }

    @Test
    public void throw_error_when_starting_point_is_out_of_the_grid() {
        Grid grid = new Grid(2);
        char[] moves = new char[]{'f', 'f', 'f'};
        Command command = new Command(moves);
        Position position = new Position(3, 2, 'N');

        Rover rover = new Rover(grid);

        Throwable exception = assertThrows(NullPointerException.class,
                () -> {rover.move(position, command);});
    }

    @Test
    public void throw_error_when_starting_point_has_an_obstacle() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f', 'f', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 2, 'N');

        grid.setObstacle(new Coordinate(1, 2));
        grid.setObstacle(new Coordinate(1, 3));
        Rover rover = new Rover(grid);

        Throwable exception = assertThrows(RuntimeException.class,
                () -> {rover.move(position, command);});
        assertEquals("An obstacle is detected in position 1:2:N; current position is null", exception.getMessage());
    }

    @Test
    public void throw_error_when_rover_try_to_cross_edges_then_position_is_the_last_possible_move() {
        Grid grid = new Grid(2);
        char[] moves = new char[]{'f', 'f', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        Rover rover = new Rover(grid);

        Throwable exception = assertThrows(NullPointerException.class,
                () -> {rover.move(position, command);});

        assertEquals("You are try to go out of the board : 1:2:N; current position is 1:1:N", exception.getMessage());
        assertEquals("1:1:N", rover.getCurrentPosition());
    }

    @Test
    public void throw_error_when_obstacle_is_reaches_then_position_is_the_last_possible_move() {
        Grid grid = new Grid(10);
        char[] moves = new char[]{'f', 'f', 'f'};
        Command command = new Command(moves);
        Position position = new Position(1, 1, 'N');

        grid.setObstacle(new Coordinate(1, 4));
        grid.setObstacle(new Coordinate(1, 3));
        Rover rover = new Rover(grid);

        Throwable exception = assertThrows(RuntimeException.class,
                () -> {rover.move(position, command);});

        assertEquals("An obstacle is detected in position 1:3:N; current position is 1:2:N", exception.getMessage());
        assertEquals("1:2:N", rover.getCurrentPosition());
    }

    @Test
    public void throw_error_when_starting_point_is_null() {
        Grid grid = new Grid(2);
        char[] moves = new char[]{'f', 'f', 'f'};
        Command command = new Command(moves);
        Position position = null;

        Rover rover = new Rover(grid);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {rover.move(position, command);});
    }

    @Test
    public void throw_error_when_command_is_null() {
        Grid grid = new Grid(2);
        Command command = null;
        Position position = null;

        Rover rover = new Rover(grid);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {rover.move(position, command);});
    }

    @Test
    public void throw_error_when_command_is_empty() {
        Grid grid = new Grid(2);
        Command command = new Command(new char[]{});
        Position position = null;

        Rover rover = new Rover(grid);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {rover.move(position, command);});
    }

}
