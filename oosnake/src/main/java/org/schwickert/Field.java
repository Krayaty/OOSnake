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
        snake.getCells().forEach(c -> {
            cells.put(c, CellStatus.SNAKE);
        });
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
        } while (cells.get(randomPos) == CellStatus.SNAKE);

        cells.put(randomPos, CellStatus.FRUIT);
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

    @Override
    public String toString() {
        String res = "";
        int yBefore = 0;
        Cell[] cellArray = new Cell[XMAX * YMAX];
        cellArray = cells.keySet().toArray(cellArray);
        List<Cell> sortedCells = Arrays.asList(cellArray);
        sortedCells.sort(new CellComparator());
        for (Cell cell : sortedCells) {
            if (cell.getY() > yBefore) {
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
