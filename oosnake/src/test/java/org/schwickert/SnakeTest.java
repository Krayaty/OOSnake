package org.schwickert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;    
    
public class SnakeTest {

    @Before
    public void setup(){

    }
        
    @Test
    public void snakeMovedRight() {
        ArrayList<Cell> cells = new ArrayList<>();

        Snake s1 =  new Snake(0, 0);   

        s1.moveRight();
        assertEquals( new Snake(1, 0), s1);
    }
}
    