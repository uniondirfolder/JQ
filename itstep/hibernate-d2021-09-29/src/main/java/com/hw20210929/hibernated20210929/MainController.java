package com.hw20210929.hibernated20210929;

import com.hw20210929.hibernated20210929.utils.DialogManager;
import com.hw20210929.hibernated20210929.utils.LocalManager;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

public class MainController extends Observable implements Initializable {
    private CollectionNotes collectionNotes = new CollectionNotes();
    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtSearch;
    @FXML
    private TableView tableNotes;
    @FXML
    private Label lblCount;
    @FXML
    private TableColumn<Note, String> columnDate;
    @FXML
    private TableColumn<Note, String> columnBody;
    @FXML
    ComboBox cmbLocals;

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditController editController;
    private Stage editDialogStage;
    private ObservableList<Note> backUpList;

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("edit.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("Locale", new Locale("ru")));
            fxmlEdit = fxmlLoader.load();
            editController = fxmlLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initListeners() {
        collectionNotes.getNotes().addListener((ListChangeListener<Note>) change -> {
            updateCountLabel();
        });

        tableNotes.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                editController.setNote((Note) tableNotes.getSelectionModel().getSelectedItem());
                showDialog();
            }
        });

        cmbLocals.setOnAction((EventHandler<ActionEvent>) actionEvent -> {
            Lang slcLang =(Lang) cmbLocals.getSelectionModel().getSelectedItem();
            LocalManager.setCurrentLang(slcLang);

            setChanged();
            notifyObservers(slcLang);
        });
    }

    private void updateCountLabel() {
        lblCount.setText(resourceBundle.getString("lbl_CountNotes") + " " + collectionNotes.getNotes().size());
    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }

        Button clickedButton = (Button) source;

        Note selectedNote = (Note) tableNotes.getSelectionModel().getSelectedItem();

        //Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();

        if (selectedNote != null) {
            editController.setNote(selectedNote);
        }


        switch (clickedButton.getId()) {
            case "btnAdd":
                editController.setNote(new Note());
                showDialog();
                collectionNotes.create(editController.getNote());
                break;

            case "btnEdit":
                if (!noteIsSelected(selectedNote)) {
                    return;
                }
                editController.setNote((Note) tableNotes.getSelectionModel().getSelectedItem());
                showDialog();
                break;


            case "btnDelete":
                if (!noteIsSelected(selectedNote)) {
                    return;
                }
                collectionNotes.delete((Note) tableNotes.getSelectionModel().getSelectedItem());
                break;

        }

    }

    private boolean noteIsSelected(Note selectedNote) {
        if (selectedNote == null) {
            DialogManager.showInfoDialog(resourceBundle.getString("error"), resourceBundle.getString("select_note"));
            return false;
        }
        return true;
    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle(resourceBundle.getString("app_title_Edit"));
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }

        editDialogStage.showAndWait(); // для ожидания закрытия окна

    }

    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        columnDate.setCellValueFactory(new PropertyValueFactory<Note, String>("date"));
        columnBody.setCellValueFactory(new PropertyValueFactory<Note, String>("body"));
        initListeners();
        initLoader();
        fillData();
        tableNotes.setItems(collectionNotes.getNotes());
    }

    private void fillData() {
        fillTable();
        fillLang();
    }

    private void fillLang() {
        Lang langRu = new Lang(LocalManager.RU_CODE, resourceBundle.getString("ru"), LocalManager.RU_LOCALE, 0);
        Lang langEn = new Lang(LocalManager.EN_CODE, resourceBundle.getString("en"), LocalManager.EN_LOCALE, 1);

        cmbLocals.getItems().add(langRu);
        cmbLocals.getItems().add(langEn);

        if(LocalManager.getCurrentLang()==null){
            cmbLocals.getSelectionModel().select(0);
        }
        else{
            cmbLocals.getSelectionModel().select(LocalManager.getCurrentLang().getIndex());
        }
    }

    private void fillTable() {
        // from db
        collectionNotes.read();
        backUpList = FXCollections.observableArrayList();
        backUpList.addAll(collectionNotes.getNotes());
        tableNotes.setItems(collectionNotes.getNotes());
    }

    public void actionSearchButton(ActionEvent actionEvent) {
        collectionNotes.getNotes().clear();
        for (Note note : backUpList) {
            if ((note.getBody().toLowerCase().contains(txtSearch.getText().toLowerCase(Locale.ROOT)))) {
                collectionNotes.getNotes().add(note);
            }
        }
    }
}
