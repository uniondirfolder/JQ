package com.hw20210929.hibernated20210929;

import com.hw20210929.hibernated20210929.utils.DialogManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    @FXML
    private Label lblDate;
    @FXML
    private Label lblNote;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField txtNote;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;

    private Note note;

    public void setNote(Note note) {
        this.note = note;
        datePicker.setUserData(note.getDate());
        txtNote.setText(note.getBody());

    }

    public Note getNote() {
        return note;
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent) {

        if (txtNote==null || txtNote.getText()== null || txtNote.getText().trim().length() == 0 || datePicker.getValue() == null) {
            DialogManager.showInfoDialog(resourceBundle.getString("error"), resourceBundle.getString("empty_note"));
            return;
        } else {
            note.setDate(datePicker.getValue().toString());
            note.setBody(txtNote.getText());
            actionClose(actionEvent);
        }
    }

    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
}
