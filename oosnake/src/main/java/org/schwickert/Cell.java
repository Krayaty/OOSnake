package org.schwickert;

public class Cell{

    private int x;
    private int y;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
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

    @Override
    public String toString(){
        
        return x + " " + y;
    }
}