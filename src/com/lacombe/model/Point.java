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

    public Point incrementY(int increment) {
        if(isIntSuperiorThanCapacity(y + increment))
            return new Point(x,increment,capacity);
        if(isNumberEqualToZero(y + increment))
            return new Point(x,capacity,capacity);
        return new Point(x,y + increment,capacity);
    }

    public Point incrementX(int increment) {
        if(isIntSuperiorThanCapacity(x + increment))
            return new Point(1,y,capacity);
        if(isNumberEqualToZero(x + increment))
            return new Point(capacity,y,capacity);
        return new Point(x+increment,y,capacity);
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
}
