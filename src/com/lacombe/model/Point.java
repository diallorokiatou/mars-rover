package src.com.lacombe.model;

import java.util.Objects;

public class Point{
    final int x;
    final int y;

    int capacity;

    public Point(int x, int y, int capacity) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
    }

    public Point incrementY() {
        if(isIntSuperiorThanCapacity(y + 1))
            return new Point(x,1,capacity);
        return new Point(x,y + 1,capacity);
    }

    public Point decrementY() {
        if(isNumberEqualToZero(y - 1))
            return new Point(x,capacity,capacity);
        return new Point(x,y - 1,capacity);
    }

    public Point incrementX() {
        if(isIntSuperiorThanCapacity(x + 1))
            return new Point(1,y,capacity);
        return new Point(x+1,y,capacity);
    }

    public Point decrementX() {
        if(isNumberEqualToZero(x - 1))
            return new Point(capacity,y,capacity);
        return new Point(x - 1,y,capacity);
    }

    private boolean isNumberEqualToZero(int number) {
        return number == 0;
    }

    private boolean isIntSuperiorThanCapacity(int number) {
        return number > capacity;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && capacity == point.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, capacity);
    }

    public boolean isLessOrEqualToCapacity() {
        return x <= capacity && y <= capacity;
    }
}
