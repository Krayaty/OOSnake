package org.schwickert;

import java.util.Objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cell{

    public int x;
    public int y;

    public Cell getRightNeighbour(){
        return new Cell(this.x + 1, this.y);
    }

    public Cell getLeftNeighbour(){
        return new Cell(this.x - 1, this.y);
    }

    public Cell getTopNeighbour(){
        return new Cell(this.x, this.y - 1);
    }

    public Cell getBottomNeighbour(){
        return new Cell(this.x, this.y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString(){
        
        return x + " " + y;
    }
}