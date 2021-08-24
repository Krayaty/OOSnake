package org.schwickert;

import java.util.Comparator;

public class CellComparator implements Comparator<Cell>{

    @Override
    public int compare(Cell o1, Cell o2) {
        
        if(o1.y < o2.y){
            return -1;
        }else if(o1.y == o2.y){
            if(o1.x < o2.x){
                return -1;
            }else if(o1.x == o2.x){
                return 0;
            }
        }
        return 1;
        
    }
    
}
