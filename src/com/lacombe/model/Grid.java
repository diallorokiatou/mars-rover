package src.com.lacombe.model;

import java.util.ArrayList;
import java.util.List;


public class Grid {
    List<GridCell> gridPlate;

    public Grid(int capacity) {
        this.gridPlate = new ArrayList<>(capacity);
        init(capacity);
    }

    private void init(int capacity) {
        for(int i=0;i<capacity;i++){
            for(int j=0;j<capacity;j++){
                GridCell gridCell = new GridCell(i,j);
                this.gridPlate.add(gridCell);
            }
        }
    }

    public GridCell getCellByHisCoordinate(Coordinate coordinate) {
        for (GridCell gridCell: gridPlate) {
            if(gridCell.haveSameCordinate(coordinate))
                return gridCell;
        }
        return null;
    }

    public void setObstacle(Coordinate coordinate) {
        GridCell gridCell = getCellByHisCoordinate(coordinate);
        if(gridCell == null) return;
        gridCell.setObstacle();
    }

    public boolean hasObstacle(Coordinate coordinate) {
        GridCell gridCell = getCellByHisCoordinate(coordinate);
        if(gridCell == null) return true;
        return gridCell.hasObstacle;
    }

    public void print() {
        for (GridCell gridCell: gridPlate) {
            System.out.println(gridCell);
        }
    }

    public int size(){
        return gridPlate.size();
    }
}
