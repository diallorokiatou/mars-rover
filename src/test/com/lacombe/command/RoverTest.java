package src.test.com.lacombe.command;

import org.junit.jupiter.api.Test;
import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RoverTestShould {

    @Test
    public void init_the_rover_starting_Rover() {
        Grid grid = new Grid(4);
        Rover rover_starting_at_x_1_y_1_direction_E = new Rover(1, 1, 'E', grid);
        Rover rover_starting_at_x_1_y_2_direction_W = new Rover(1, 2, 'W', grid);
        Rover rover_starting_at_x_2_y_1_direction_N = new Rover(2, 1, 'N', grid);
        Rover rover_starting_at_x_1_y_1_direction_S = new Rover(1, 1, 'S', grid);

        assertEquals("1:1:E", rover_starting_at_x_1_y_1_direction_E.toString());
        assertEquals("1:2:W", rover_starting_at_x_1_y_2_direction_W.toString());
        assertEquals("2:1:N", rover_starting_at_x_2_y_1_direction_N.toString());
        assertEquals("1:1:S", rover_starting_at_x_1_y_1_direction_S.toString());
    }

    @Test
    public void throw_illegal_argument_error_when_commands_is_null() {
        final Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'E', grid);

        assertThrows(NullPointerException.class,
                () -> rover.receive(null));

        assertEquals("1:1:E", rover.toString());
    }
    @Test
    public void not_move_when_commands_size_is_less_than_1() {
        char[] commands = new char[]{};
        final Grid grid = new Grid(4);

        Rover rover = new Rover(1, 1, 'E', grid);
        
        rover.receive(commands);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
   public void move_forward_when_direction_is_East() {
        char[] commands = new char[]{'f'};
        Grid grid =  new Grid(4);
        Rover rover = new Rover(1, 1, 'E', grid);
        
        rover.receive(commands);

        assertEquals("2:1:E", rover.toString());
    }

   @Test
    public void move_forward_when_direction_is_West() {
        char[] commands = new char[]{'f'};
       final Grid grid = new Grid(4);
       Rover rover = new Rover(2, 1, 'W', grid);

        rover.receive(commands);

        assertEquals("1:1:W", rover.toString());
    }

    @Test
    public void move_forward_when_direction_is_South() {
        char[] commands = new char[]{'f'};
        final Grid grid = new Grid(4);
        Rover rover = new Rover(1, 2, 'S', grid);

        rover.receive(commands);

        assertEquals("1:1:S", rover.toString());
    }

    @Test
    public void move_forward_when_direction_is_North() {
        char[] commands = new char[]{'f'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'N', grid);
        
        rover.receive(commands);

        assertEquals("1:2:N", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_East() {
        char[] commands = new char[]{'b'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(2, 1, 'E', grid);
        
        rover.receive(commands);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_West() {
        char[] commands = new char[]{'b'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'W', grid);
        
        rover.receive(commands);

        assertEquals("2:1:W", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_South() {
        char[] commands = new char[]{'b'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'S', grid);
        
        rover.receive(commands);

        assertEquals("1:2:S", rover.toString());
    }

    @Test
    public void move_backward_when_direction_is_North() {
        char[] commands = new char[]{'b'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 2, 'N', grid);
        
        rover.receive(commands);

        assertEquals("1:1:N", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_East() {
        char[] commands = new char[]{'l'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'E', grid);

        rover.receive(commands);

        assertEquals("1:1:N", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_West() {
        char[] commands = new char[]{'l'};
        final Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'W', grid);

        rover.receive(commands);

        assertEquals("1:1:S", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_South() {
        char[] commands = new char[]{'l'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'S', grid);

        rover.receive(commands);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
    public void move_left_when_direction_is_North() {
        char[] commands = new char[]{'l'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'N', grid);

        rover.receive(commands);

        assertEquals("1:1:W", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_East() {
        char[] commands = new char[]{'r'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'E', grid);

        rover.receive(commands);

        assertEquals("1:1:S", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_West() {
        char[] commands = new char[]{'r'};
        Grid grid =  new Grid(4);
        Rover rover = new Rover(1, 1, 'W', grid);

        rover.receive(commands);

        assertEquals("1:1:N", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_South() {
        char[] commands = new char[]{'r'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'S', grid);

        rover.receive(commands);

        assertEquals("1:1:W", rover.toString());
    }

    @Test
    public void move_right_when_direction_is_North() {
        char[] commands = new char[]{'r'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'N', grid);

        rover.receive(commands);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
    public void wrap_at_West_edge() {
        char[] commands = new char[]{'f'};
        final Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'W', grid);

        rover.receive(commands);

        assertEquals("4:1:W", rover.toString());
    }

    @Test
    public void wrap_at_East_edge() {
        char[] commands = new char[]{'f'};
        final Grid grid = new Grid(4);
        Rover rover = new Rover(4, 1, 'E', grid);

        rover.receive(commands);

        assertEquals("1:1:E", rover.toString());
    }

    @Test
    public void wrap_at_North_edge() {
        char[] commands = new char[]{'f'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 4, 'N', grid);

        rover.receive(commands);

        assertEquals("1:1:N", rover.toString());
    }

    @Test
    public void wrap_at_South_edge() {
        char[] commands = new char[]{'f'};
        Grid grid = new Grid(4);
        Rover rover = new Rover(1, 1, 'S', grid);

        rover.receive(commands);

        assertEquals("1:4:S", rover.toString());
    }

    @Test
    public void move_forward_to_position_2_1_S_and_report_obstacle_at_position_2_4() {
        char[] commands = new char[]{'f'};
        Point[] obstacles = new Point[]{new Point(2, 4, 4), new Point(3, 2, 4)};
        final Grid grid = new Grid(4, obstacles);
        Rover rover = new Rover(2, 1, 'S', grid);
        
        Throwable exception = assertThrows(RuntimeException.class,
                () -> rover.receive(commands));
        assertEquals("An obstacle is detected at position 2:4; The current position is 2:1:S", exception.getMessage());
    }

    @Test
    public void move_backward_to_position_2_1_S_and_report_obstacle_at_position_2_4() {
        char[] commands = new char[]{'b'};
        Point[] obstacles = new Point[]{new Point(2, 3, 4), new Point(3, 2, 4)};
        Grid grid  = new Grid(4, obstacles);
        Rover rover = new Rover(2, 2, 'S', grid);

        Throwable exception = assertThrows(RuntimeException.class,
                () -> rover.receive(commands));
        assertEquals("An obstacle is detected at position 2:3; The current position is 2:2:S", exception.getMessage());
    }

    @Test
    public void move_backward_to_position_2_1_E_and_report_obstacle_at_position_1_1() {
        char[] commands = new char[]{'b'};
        Point[] obstacles = new Point[]{new Point(2, 4, 4), new Point(3, 2, 4)};
        Grid grid = new Grid(4, obstacles);
        Rover rover = new Rover(4, 2, 'E', grid);

        Throwable exception = assertThrows(RuntimeException.class,
                () -> rover.receive(commands));

        assertEquals("An obstacle is detected at position 3:2; The current position is 4:2:E", exception.getMessage());
    }

    @Test
    public void don_t_reach_obstacle_at_position_2_4_and_stay_at_position_2_1_S() {
        char[] commands = new char[]{'f'};
        Point[] obstacles = new Point[]{new Point(2, 4, 4)};
        final Grid grid = new Grid(4, obstacles);
        Rover rover = new Rover(2, 1, 'S', grid);

        assertThrows(RuntimeException.class,
                () -> rover.receive(commands));
        assertEquals("2:1:S",rover.toString());
    }

    @Test
    public void validate_point_in_interval_beetween_one_to_capacity() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Point(5, 4, 4));
        assertEquals("Point(x,y) must be in range [1,4]",illegalArgumentException.getMessage());

    }

}
