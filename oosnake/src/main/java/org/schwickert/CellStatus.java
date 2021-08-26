package org.schwickert;

import java.awt.Color;

import lombok.Getter;

@Getter
public enum CellStatus {

    EMPTY(Color.WHITE), FRUIT(Color.RED), SNAKE_HEAD(new Color(0, 102, 0)), SNAKE_BODY(Color.GREEN);

    public Color color;

    private CellStatus(Color color) {
        this.color = color;
    }
}
