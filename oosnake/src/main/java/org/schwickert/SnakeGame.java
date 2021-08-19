package org.schwickert;

public class SnakeGame{
    
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    public static void main(String[] args) {
    
        Snake snake  = new Snake(WIDTH / 2, HEIGHT / 2);
        Field f1 = new Field(WIDTH, HEIGHT, snake);
        
        f1.run();
    }
    
}