package com.cgvsu.test;


import com.cgvsu.rasterizationfxapp.RasterizationApplication;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.testfx.framework.junit5.Start;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

class RasterizationApplicationTest {

    private Stage stage;

    @Start
    void start(Stage stage) throws Exception {
        this.stage = stage;
        new RasterizationApplication().start(stage);
    }

    @Test
    void testSceneDimensions() {
        Scene scene = stage.getScene();
        assertEquals(800, scene.getWidth());
        assertEquals(600, scene.getHeight());
    }

    @Test
    void testFXMLIsLoaded() {
        Parent root = (Parent) stage.getScene().getRoot();
        assertNotNull(root);
    }

    @Test
    void testFXMLResourceIsFound() throws IOException {
        String fxmlPath = "mainwindow.fxml";
        java.net.URL fxmlUrl = RasterizationApplication.class.getResource(fxmlPath);
        assertNotNull(fxmlUrl);
    }
}