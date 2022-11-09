package src.com.lacombe.model;

public record Point(int x, int y){

    @Override
    public String toString() {
        return x + ":" + y;
    }

    public Point incrementY(int increment){
        return new Point(x, y + increment);
    }

    public Point incrementX(int increment) {
        return new Point(x + increment, y);
    }

}
