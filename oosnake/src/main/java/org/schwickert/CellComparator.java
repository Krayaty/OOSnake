package org.schwickert;

import java.util.Comparator;

public class CellComparator implements Comparator<Cell>{

    @Override
    public int compare(Cell o1, Cell o2) {
        
        if(o1.getY() < o2.getY()){
            return -1;
        }else if(o1.getY() == o2.getY()){
            if(o1.getX() < o2.getX()){
                return -1;
            }else if(o1.getX() == o2.getX()){
                return 0;
            }
        }
        return 1;
        
    }
    
}
