package org.schwickert;

import java.awt.Color;

public enum CellStatus {

    EMPTY(Color.WHITE), SNAKE(Color.GREEN), FRUIT(Color.RED), SNAKE_HEAD(new Color(0, 102, 0));

    public Color color;

    private CellStatus(Color color) {
        this.color = color;
    }
}
