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
    private Cell fruit;

    public Field(int x, int y, Snake snake) {

        XMAX = x;
        YMAX = y;
        this.snake = snake;
        drawSnake();
        generateFruit();
        this.draw();
    }

    public void draw(){
        for (int i = 0; i < YMAX; i++) {
            for (int j = 0; j < XMAX; j++) {
                cells.put(new Cell(j, i), CellStatus.EMPTY);

            }
        }
        drawSnake();
        drawFruit();
    }

    public void generateFruit(){
        Random random = new Random();
        int randomX;
        int randomY;
        Cell randomPos;

        do {
            randomX = random.nextInt(XMAX);
            randomY = random.nextInt(YMAX);
            randomPos = new Cell(randomX, randomY);
        } while (isSnakeCell(randomPos));
        
        fruit = randomPos; 
    }

    public void drawFruit() {
        cells.put(fruit, CellStatus.FRUIT);
    }
   
    public void drawSnake() {
        cells.put(snake.getHead(), CellStatus.SNAKE_HEAD);
        if (snake.getBody() != null) {
            for (Cell cell : snake.getBody()) {
                cells.put(cell, CellStatus.SNAKE_BODY);
            } 
        } 
    }
    public boolean isSnakeCell(Cell cell){
        return cells.get(cell) == CellStatus.SNAKE_BODY && cells.get(cell) == CellStatus.SNAKE_HEAD;
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

        if (nextCell.x > XMAX - 1 || nextCell.x < 0 || nextCell.y > YMAX - 1 || nextCell.y < 0) {
            return true;
        }
        return false;
    }

    public boolean isInBounds(Cell nextCell){
        return !isOutOfBounds(nextCell);
    }

    public SnakeStatus moveSnakeRight(){
        if (isInBounds(snake.getHead().getRightNeighbour())) {
            snake.moveRight();
            this.draw();
            return SnakeStatus.ALIVE;
        } 
        return SnakeStatus.DEAD;
    }

    public SnakeStatus moveSnakeLeft(){
        if (isInBounds(snake.getHead().getLeftNeighbour())) {
            snake.moveLeft();
            this.draw();
            return SnakeStatus.ALIVE;
        } 
        return SnakeStatus.DEAD;
    }

    public SnakeStatus moveSnakeUp(){
        if (isInBounds(snake.getHead().getTopNeighbour())) {
            snake.moveUp();
            this.draw();
            return SnakeStatus.ALIVE;
        } 
        return SnakeStatus.DEAD;
    }

    public SnakeStatus moveSnakeDown(){
        if (isInBounds(snake.getHead().getBottomNeighbour())) {
            snake.moveDown();
            this.draw();
            return SnakeStatus.ALIVE;
        } 
        return SnakeStatus.DEAD;
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
