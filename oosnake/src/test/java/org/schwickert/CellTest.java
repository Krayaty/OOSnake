package org.schwickert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;    
    
public class CellTest {

    @Before
    public void setup(){

    }
        
    @Test
    public void isCorrectRightNeighbour() {
        Cell c1 = new Cell(0, 0);
        assertEquals(new Cell(1, 0), c1.getRightNeighbour());
        
    }
}
    