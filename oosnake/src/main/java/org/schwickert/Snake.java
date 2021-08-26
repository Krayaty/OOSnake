package org.schwickert;

import java.util.ArrayList;
import java.util.Objects;

import lombok.Getter;

@Getter
public class Snake {

    private ArrayList<Cell> cells = new ArrayList<>();

    private SnakeDirection direction;
    private SnakeStatus status;

    public Snake(int x, int y) {
        this.cells.add(new Cell(x, y));
        this.direction = SnakeDirection.RIGHT;
        this.status = SnakeStatus.ALIVE;
    }

    public Cell getHead() {
        return cells.get(0);
    }

    public boolean isHead(Cell c) {
        return c.equals(this.getHead());
    }

    public ArrayList<Cell> getBody() {
        ArrayList<Cell> body = (ArrayList<Cell>) cells.clone();
        
        body.remove(0);
        return body;
    }

    public void moveRight(){
        cells.add(0, this.getHead().getRightNeighbour());
        cells.remove(cells.size() - 1);
    }

    public void moveLeft(){
        cells.add(0, this.getHead().getLeftNeighbour());
        cells.remove(cells.size() - 1);
    }

    public void moveUp(){
        cells.add(0, this.getHead().getTopNeighbour());
        cells.remove(cells.size() - 1);
    }

    public void moveDown(){
        cells.add(0, this.getHead().getBottomNeighbour());
        cells.remove(cells.size() - 1);
    }

    public void turnUp(){
        if (this.direction != SnakeDirection.DOWN) {
            direction = SnakeDirection.UP;
        }
    }

    public void turnRight(){
        if (this.direction != SnakeDirection.LEFT) {
            direction = SnakeDirection.RIGHT;
        }
    }

    public void turnDown(){
        if (this.direction != SnakeDirection.UP) {
            direction = SnakeDirection.DOWN;
        }
    }

    public void turnLeft(){
        if (this.direction != SnakeDirection.RIGHT) {
            direction = SnakeDirection.LEFT;
        }
    }

    public void eatFruit(){
        if (this.direction == SnakeDirection.UP) {
            cells.add(0, this.getHead().getTopNeighbour());
        }else if (this.direction == SnakeDirection.RIGHT) {
            cells.add(0, this.getHead().getRightNeighbour());
        }else if (this.direction == SnakeDirection.DOWN) {
            cells.add(0, this.getHead().getBottomNeighbour());
        }else {
            cells.add(0, this.getHead().getLeftNeighbour());
        }
    }

    public void setStatus(SnakeStatus status){
        this.status = status;
    }

    public boolean isAlive(){
        return this.status == SnakeStatus.ALIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Snake)) {
            return false;
        }
        Snake snake = (Snake) o;
        
        if (this.cells.size() != snake.cells.size()) {
            return false;
        }
        for (int i = 0; i < this.cells.size(); i++) {
            if (!this.cells.get(i).equals(snake.cells.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cells);
    }


    @Override
    public String toString(){
        String res = "";
        for (Cell cell : cells) {
            res += cell.toString();
        }
        return res;
    }
}
