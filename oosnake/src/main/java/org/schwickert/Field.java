package org.schwickert;

import java.util.ArrayList;

public class Field {
    
    ArrayList<Cell> cells = new ArrayList<>();


    public Field(int x, int y) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {

                cells.add(new Cell(j, i, CellStatus.EMPTY));
            }
        }
    }
    
    @Override
    public String toString() {
        String res = "";
        int yBefore = 0;
            for (Cell cell : cells) {
                if (cell.getY() > yBefore) {
                    yBefore++;
                    res += "| \n";
                }
                res += cell;
            }
        return res + "|";
    }
}
