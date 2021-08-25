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

    public boolean isHead(Cell c) {
        return c.equals(this.getHead());
    }

    public ArrayList<Cell> getCells() {
        return this.cells;
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

    @Override
    public String toString(){
        String res = "";
        for (Cell cell : cells) {
            res += cell.toString();
        }
        return res;
    }
}
