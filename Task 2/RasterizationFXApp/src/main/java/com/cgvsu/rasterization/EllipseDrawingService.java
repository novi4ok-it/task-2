package com.cgvsu.rasterization;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
public interface EllipseDrawingService {
        void drawFilledEllipseByCorners(Canvas canvas, double x, double y, double width, double height, Color startColor, Color endColor);
        void drawFilledEllipseByCenter(Canvas canvas, double centerX, double centerY, double a, double b, Color startColor, Color endColor);
    }