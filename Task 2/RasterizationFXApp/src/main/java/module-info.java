module com.cgvsu.rasterizationfxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.platform.commons;

    // TestFX
    requires org.testfx.junit5;

    // Mockito
    requires org.mockito;
    requires org.testng;
    requires org.junit.jupiter.api;

    // Экспорт пакетов (если нужно)
    opens com.cgvsu.rasterizationfxapp to javafx.fxml;
    exports com.cgvsu.rasterizationfxapp;
}