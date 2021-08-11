package org.schwickert;

public class Cell{

    private int x;
    private int y;
    private CellStatus status;

    public Cell(int x, int y, CellStatus status){
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public void setX(int x) {
        this.x = x;
    }


    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public CellStatus getStatus() {
        return this.status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        
        if (status == CellStatus.EMPTY) {
            return "| ";
        }else if (status == CellStatus.FRUIT) {
            return "|X";            
        }else{
            return "|O";
        }
    }
}