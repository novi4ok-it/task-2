package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Canvas canvas;

    @FXML
    public void initialize() {
        CanvasResizer canvasResizer = new CanvasResizer();
        canvasResizer.resizeCanvas(anchorPane, canvas);

        DrawingManager drawingManager = new DrawingManager(new RasterizationOfEllipse());

        drawingManager.drawEllipse(canvas, 200, 0, 400, 500, Color.PURPLE, Color.BLACK);
    }
}