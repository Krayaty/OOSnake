package org.schwickert;

public class SnakeGame{

    public static void main(String[] args) {
        Cell c1 = new Cell(0, 0, CellStatus.EMPTY);
        Cell c2 = new Cell(1, 0, CellStatus.FRUIT);

        System.out.println(c1);
        System.out.println(c2);
    }
    
}