package com.nvv.notes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NotesApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(NotesApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 275);
        stage.setTitle("Мои заметки");
        stage.setMinHeight(600);
        stage.setMinWidth(400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
