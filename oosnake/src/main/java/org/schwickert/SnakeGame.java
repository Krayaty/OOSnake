package org.schwickert;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;

public class SnakeGame extends JFrame implements KeyListener{

    private final int TIMER_DELAY = 150;
    private final int CELL_SIZE = 10;
    private final int COLOUMNS;
    private final int ROWS;
    private Snake snake;
    private Field field;
    private Timer timer;
    private boolean lock = false;

    public static void main(String[] args) {

        SnakeGame game = new SnakeGame(15, 15);

    }

    public SnakeGame(int coloumns, int rows) {
        COLOUMNS = coloumns;
        ROWS = rows;
        

        snake = new Snake(COLOUMNS / 2, ROWS / 2);
        field = new Field(COLOUMNS, ROWS, snake);

        
        timer = new Timer(TIMER_DELAY, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            if (!snake.isAlive()) {
                timer.stop();
                return;
            }
            if (field.snakeOnFruit()) {
                snake.eatFruit();
                field.generateFruit();
                field.draw();
            }else if (snake.getDirection() == SnakeDirection.UP) {
                field.moveSnakeUp();
            }else if(snake.getDirection() == SnakeDirection.RIGHT){
                field.moveSnakeRight();
            }else if(snake.getDirection() == SnakeDirection.DOWN){
                field.moveSnakeDown();
            }else {
                field.moveSnakeLeft();
            } 
                updateField();
                lock = false;
            }
        });

        this.initField();
        
        this.setFocusable(true);
        this.addKeyListener(this);
        this.setTitle("Snake");
        this.setSize(COLOUMNS * 50, ROWS * 50);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.timer.start();
    }

    public void initField() {
        JPanel content = new JPanel(new GridLayout(ROWS, COLOUMNS));

        for (Cell cell : field.getSortedCellList()) {
            JLabel label = new JLabel();
            label.setSize(CELL_SIZE, CELL_SIZE);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setOpaque(true);
            label.setBackground(field.getColorOfCell(cell));

            label.setVisible(true);
            content.add(label);

        }
        this.setContentPane(content);
    }

    public void updateField(){
        Component[] labels= this.getContentPane().getComponents();

        for (int i = 0; i < labels.length; i++) {
            labels[i].setBackground(field.getColorOfCell(field.getSortedCellList().get(i)));
            if (field.getSortedCellList().get(i).equals(field.getFruit()) && field.getSortedCellList().get(i).equals(field.getSnakeHead())) {
                labels[i].setBackground(CellStatus.SNAKE_HEAD.getColor());
            }
        }
        SwingUtilities.updateComponentTreeUI(this);
        this.invalidate();
        this.validate();
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (!lock) {
            if (e.getKeyChar() == 'd') {
                snake.turnRight();
                lock = true;
            } else if (e.getKeyChar() == 'a') {
                snake.turnLeft();
                lock = true;
            } else if (e.getKeyChar() == 'w' ) {
                snake.turnUp();
                lock = true;
            } else if (e.getKeyChar() == 's' ) {
                snake.turnDown();
                lock = true;
            }
        } 
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}