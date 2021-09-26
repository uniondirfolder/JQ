module com.hw20210929.hibernated20210929 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.hw20210929.hibernated20210929 to javafx.fxml;
    exports com.hw20210929.hibernated20210929;
}