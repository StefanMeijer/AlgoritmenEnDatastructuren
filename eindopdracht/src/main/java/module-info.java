module com.example.eindopdracht {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.eindopdracht to javafx.fxml;
    exports com.example.eindopdracht;
}