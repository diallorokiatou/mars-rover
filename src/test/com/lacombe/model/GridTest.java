package src.test.com.lacombe.model;

import org.junit.jupiter.api.Test;
import src.com.lacombe.model.Grid;

import static org.junit.jupiter.api.Assertions.*;

class GridTestSchould {

    @Test
    void init_the_grid_with_capacity_3(){
        Grid grid = new Grid(3);

        grid.print();

        assertEquals(9, grid.size());
    }
}