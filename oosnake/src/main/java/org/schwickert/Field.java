package org.schwickert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Field {
    
    private Map<Cell, CellStatus> cells = new HashMap<>();


    public Field(int x, int y, Snake snake) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {

                if(i == (int) y / 2 && j == (int) x / 2){
                    cells.put(new Cell(j, i), CellStatus.SNAKE);
                }else{
                    cells.put(new Cell(j, i), CellStatus.EMPTY);
                }
            }
        }
        generateFruit();
    }
    
    public void generateFruit(){
        Random random = new Random();
        int randomPos;

        do {
            randomPos = random.nextInt(cells.size());
        } while (cells.get(randomPos) == CellStatus.SNAKE); // stimmt nicht
        
        cells.get(randomPos) =  CellStatus.FRUIT;
        cells.put(key, value)
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
                if (status == CellStatus.EMPTY) {
                    res += "| ";
                }else if (status == CellStatus.FRUIT) {
                    res += "|X";            
                }else{
                    res += "|O";
                }
            }
        return res + "|";
    }
}
