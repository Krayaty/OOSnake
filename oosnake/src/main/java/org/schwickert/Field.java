package org.schwickert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.Color;

public class Field {

    private Map<Cell, CellStatus> cells = new HashMap<Cell, CellStatus>();
    private final int XMAX;
    private final int YMAX;
    private Snake snake;
    private boolean done = false;

    public Field(int x, int y, Snake snake) {

        XMAX = x;
        YMAX = y;
        this.snake = snake;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                cells.put(new Cell(j, i), CellStatus.EMPTY);

            }
        }
        generateSnake();
        generateFruit();
    }

    public void generateSnake() {
        cells.put(snake.getHead(), CellStatus.SNAKE_HEAD);
        if (snake.getBody() != null) {
            snake.getBody().forEach(c -> {
                cells.put(c, CellStatus.SNAKE_BODY);
            });
        } 
    }

    public void generateFruit() {
        Random random = new Random();
        int randomX;
        int randomY;
        Cell randomPos;

        do {
            randomX = random.nextInt(XMAX);
            randomY = random.nextInt(YMAX);
            randomPos = new Cell(randomX, randomY);
        } while (isSnakeCell(randomPos));

        cells.put(randomPos, CellStatus.FRUIT);
    }

    public boolean isSnakeCell(Cell cell){
        return cells.get(cell) == CellStatus.SNAKE_BODY && cells.get(cell) == CellStatus.SNAKE_HEAD;
    }

    public void run() {
        int i = 0;
        while (!done) {
            if (i == 20000) {
                done = true;
            }
            i++;
            System.out.println(this);
        }
    }

    public List<Cell> getSortedCellList() {
        Cell[] cellArray = new Cell[XMAX * YMAX];
        cellArray = cells.keySet().toArray(cellArray);
        List<Cell> sortedCells = Arrays.asList(cellArray);
        sortedCells.sort(new CellComparator());
        return sortedCells;
    }

    public CellStatus getCellStatus(Cell cell) {
        return cells.get(cell);
    }

    public Color getColorOfCell(Cell cell) {
        return this.getCellStatus(cell).color;
    }

    public boolean isOutOfBounds(Cell nextCell){

        if (nextCell.x > XMAX || nextCell.x < 0 || nextCell.y > YMAX || nextCell.y < YMAX) {
            return true;
        }
        return false;
    }

    public boolean isInBounds(Cell nextCell){
        return !isOutOfBounds(nextCell);
    }

    public void moveSnakeRight(){
        if (isInBounds(snake.getHead().getRightNeighbour())) {
            snake.moveRight();
            //TODO draw methode schreiben in field
            return;
        }
        //TODO end methode schreiben in field 
    }

    public void moveSnakeLeft(){
        if (isInBounds(snake.getHead().getRightNeighbour())) {
            snake.moveLeft();
        }
        
    }

    public void moveSnakeUp(){
        if (isInBounds(snake.getHead().getRightNeighbour())) {
            snake.moveUp();
        }
        
    }

    public void moveSnakeDown(){
        if (isInBounds(snake.getHead().getRightNeighbour())) {
            snake.moveDown();
        }
        
    }

    @Override
    public String toString() {
        String res = "";
        int yBefore = 0;
        Cell[] cellArray = new Cell[XMAX * YMAX];
        cellArray = cells.keySet().toArray(cellArray);
        List<Cell> sortedCells = Arrays.asList(cellArray);
        sortedCells.sort(new CellComparator());
        for (Cell cell : sortedCells) {
            if (cell.y > yBefore) {
                yBefore++;
                res += "| \n";
            }
            if (cells.get(cell) == CellStatus.EMPTY) {
                res += "| ";
            } else if (cells.get(cell) == CellStatus.FRUIT) {
                res += "|X";
            } else if (snake.isHead(cell)) {
                res += "|Ö";
            } else {
                res += "|O";
            }
        }
        return res + "|";
    }
}
