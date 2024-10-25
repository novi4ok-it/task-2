package com.cgvsu.test;

import com.cgvsu.rasterization.EllipseDrawingService;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EllipseDrawingServiceTest {
    @Test
    void testDrawFilledEllipseByCorners() {
        Canvas canvas = mock(Canvas.class);
        EllipseDrawingService service = mock(EllipseDrawingService.class);
        service.drawFilledEllipseByCorners(canvas, 10, 10, 80, 60, Color.RED, Color.BLUE);
        verify(service).drawFilledEllipseByCorners(canvas, 10, 10, 80, 60, Color.RED, Color.BLUE);
    }

    @Test
    void testDrawFilledEllipseByCenter() {
        Canvas canvas = mock(Canvas.class);
        EllipseDrawingService service = mock(EllipseDrawingService.class);
        service.drawFilledEllipseByCenter(canvas, 50, 50, 40, 30, Color.YELLOW, Color.PURPLE);
        verify(service).drawFilledEllipseByCenter(canvas, 50, 50, 40, 30, Color.YELLOW, Color.PURPLE);
    }
}