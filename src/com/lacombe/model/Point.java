package src.com.lacombe.model;

import java.util.Objects;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementY() {
        y += 1;
    }

    public void decrementY() {
        y -= 1;
    }

    public void incrementX() {
        x += 1;
    }

    public void decrementX() {
        x -= 1;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point that = (Point) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}