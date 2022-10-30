package src.com.lacombe.model;

import java.util.Objects;

public class Coordinate {
    int abscissa;
    int ordonna;

    public Coordinate(int x, int y) {
        this.abscissa = x;
        this.ordonna = y;
    }

    public void incrementOrdonna() {
        ordonna += 1;
    }

    public void decrementOrdonna() {
        ordonna -= 1;
    }

    public void incrementAbscissa() {
        abscissa += 1;
    }

    public void decrementAbscissa() {
        abscissa -= 1;
    }

    @Override
    public String toString() {
        return abscissa + ":" + ordonna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return abscissa == that.abscissa && ordonna == that.ordonna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abscissa, ordonna);
    }
}
