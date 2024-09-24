package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

public class Rasterization {

    public static void drawRectangle(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int width, final int height,
            final Color color)
    {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y; row < y + height; ++row)
            for (int col = x; col < x + width; ++col)
                pixelWriter.setColor(col, row, color);
    }
    public static void drawFilledEllipseByCorners(Canvas canvas, double x, double y, double width, double height, Color startColor, Color endColor) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double centerX = x + width / 2;
        double centerY = y + height / 2;

        double a = width / 2;
        double b = height / 2;

        for (int row = (int) (centerY - b); row <= (int) (centerY + b); row++) {
            for (int col = (int) (centerX - a); col <= (int) (centerX + a); col++) {
                if (isPointInEllipse(centerX, centerY, a, b, col, row)) {
                    Color pixelColor = getGradientColor(startColor, endColor, centerX, centerY, a, b, col, row);
                    gc.getPixelWriter().setColor(col, row, pixelColor);
                }
            }
        }
    }

    public void drawFilledEllipseByCenter(Canvas canvas, double centerX, double centerY, double a, double b, Color startColor, Color endColor) {
        GraphicsContext gc = canvas.getGraphicsContext2D();


        for (int row = (int) (centerY - b); row <= (int) (centerY + b); row++) {
            for (int col = (int) (centerX - a); col <= (int) (centerX + a); col++) {
                if (isPointInEllipse(centerX, centerY, a, b, col, row)) {
                    Color pixelColor = getGradientColor(startColor, endColor, centerX, centerY, a, b, col, row);
                    gc.getPixelWriter().setColor(col, row, pixelColor);
                }
            }
        }
    }

    private static boolean isPointInEllipse(double centerX, double centerY, double a, double b, int x, int y) {
        double dx = x - centerX;
        double dy = y - centerY;
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1;
    }
    private static Color getGradientColor(Color startColor, Color endColor, double centerX, double centerY, double a, double b, int x, int y) {
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

        double radius = (y - centerY) / (x - centerX) > 0 ? b : -b;
        double ratio = distance / Math.abs(radius);

        ratio = Math.min(ratio, 1.0);

        return Color.color(
                startColor.getRed() + (endColor.getRed() - startColor.getRed()) * ratio,
                startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * ratio,
                startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * ratio,
                startColor.getOpacity() + (endColor.getOpacity() - startColor.getOpacity()) * ratio
        );
    }
}
