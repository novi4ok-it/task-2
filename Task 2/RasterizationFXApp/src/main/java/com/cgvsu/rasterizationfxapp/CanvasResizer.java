package com.cgvsu.rasterizationfxapp;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class CanvasResizer {
    public void resizeCanvas(AnchorPane anchorPane, Canvas canvas) {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));
    }
}
