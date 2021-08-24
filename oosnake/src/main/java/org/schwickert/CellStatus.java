package org.schwickert;

import java.awt.Color;

public enum CellStatus {

    EMPTY(Color.WHITE), SNAKE_HEAD(new Color(0, 102, 0)), SNAKE_BODY(Color.GREEN), FRUIT(Color.RED);

    public Color color;

    private CellStatus(Color color) {
        this.color = color;
    }
}
