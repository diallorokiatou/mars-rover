package src.com.lacombe.model;

import java.util.Objects;

public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveForwardEast(){
        y += 1;
    }

    public void moveForwardWest(){
        y -= 1;
    }

    public void moveForwardNorth(){
        x += 1;
    }

    public void moveForwardSouth(){
        x -= 1;
    }


    @Override
    public String toString() {
        return x + ":" +  y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
