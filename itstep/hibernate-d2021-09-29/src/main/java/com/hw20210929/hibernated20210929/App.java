package com.hw20210929.hibernated20210929;

import com.hw20210929.hibernated20210929.utils.LocalManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class App extends Application implements Observer {
    private static final String FXML_MAIN = "main.fxml";
    public static final String BUNDLES_FOLDER = "Locale";

    private Stage primaryStage;

    private Parent fxmlMain;

    private MainController mainController;
    private FXMLLoader fxmlLoader;

    private VBox currentRoot;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        createGUI(LocalManager.RU_LOCALE);

//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
////        fxmlLoader.setLocation(App.class.getResource("Locale"));
//        fxmlLoader.setResources(ResourceBundle.getBundle("Locale", new Locale("ru")));
//
//        Parent fxmlMain = fxmlLoader.load();
//        MainController mainController = fxmlLoader.getController();
//        mainController.setMainStage(stage);
//
//        //Scene scene = new Scene(fxmlLoader.load(), 300, 275);
//        stage.setTitle(fxmlLoader.getResources().getString("app_name"));
//        stage.setMinHeight(600);
//        stage.setMinWidth(400);
//        stage.setScene(new Scene(fxmlMain,300,275));
//        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update(Observable o, Object arg) {
        Lang lang = (Lang) arg;
        VBox newNode = loadFXML(lang.getLocale());
        currentRoot.getChildren().setAll(newNode.getChildren());
    }


    private VBox loadFXML(Locale locale) {
        fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource(FXML_MAIN));
        fxmlLoader.setResources(ResourceBundle.getBundle(BUNDLES_FOLDER, locale));

        VBox node = null;

        try {
            node = (VBox) fxmlLoader.load();

            mainController = fxmlLoader.getController();
            mainController.addObserver(this);
            primaryStage.setTitle(fxmlLoader.getResources().getString("app_name"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return node;
    }

    private void createGUI(Locale locale) {
        currentRoot = loadFXML(locale);
        Scene scene = new Scene(currentRoot, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(400);
        primaryStage.show();
    }
}