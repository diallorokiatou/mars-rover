package src.com.lacombe.model;

import java.util.Objects;

public record Point(int x, int y, int capacity){

    public Point {
        if (!isPointIsWellDefine(x, y, capacity))
            throw new IllegalArgumentException("Point(x,y) must be in range [1," + capacity + "]");
    }

    private boolean isPointIsWellDefine(int x, int y, int capacity) {
        return x > 0 && y > 0 && x <= capacity && y <= capacity;
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

    public boolean isLessOrEqualToCapacity() {
        return x <= capacity && y <= capacity;
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
}
