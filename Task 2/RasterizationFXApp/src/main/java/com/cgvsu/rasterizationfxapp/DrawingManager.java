package com.cgvsu.rasterizationfxapp;

import com.cgvsu.rasterization.EllipseDrawingService;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class DrawingManager {
    private final EllipseDrawingService drawingService;

    public DrawingManager(EllipseDrawingService drawingService) {
        this.drawingService = drawingService;
    }

    public void drawEllipse(Canvas canvas, double x, double y, double width, double height, Color startColor, Color endColor) {
        drawingService.drawFilledEllipseByCorners(canvas, x, y, width, height, startColor, endColor);
    }
}
