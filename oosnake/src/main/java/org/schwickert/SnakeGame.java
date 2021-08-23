package org.schwickert;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class SnakeGame extends JFrame {

    private final int CELL_SIZE = 10;
    private final int COLOUMNS;
    private final int ROWS;
    private Snake snake;
    private Field field;

    public static void main(String[] args) {

        SnakeGame game = new SnakeGame(5, 5);

    }

    public SnakeGame(int coloumns, int rows) {
        COLOUMNS = coloumns;
        ROWS = rows;

        snake = new Snake(COLOUMNS / 2, ROWS / 2);
        field = new Field(COLOUMNS, ROWS, snake);

        this.drawField();
        this.setTitle("Snake");
        this.setSize(COLOUMNS * 100, ROWS * 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        System.out.println(field);
    }

    public void drawField() {
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
        this.getContentPane().setVisible(true);
    }
}