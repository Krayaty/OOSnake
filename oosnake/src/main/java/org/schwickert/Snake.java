package org.schwickert;

import java.util.ArrayList;

public class Snake {
    
    private ArrayList<Cell> cells = new ArrayList<>();


    public Snake(int x, int y) {
        cells.add(new Cell(x, y));
    }

    public Cell getHead() {
        return cells.get(0);
    }


    public ArrayList<Cell> getCells() {
        return this.cells;
    }
}
