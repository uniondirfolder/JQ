module com.nvv.notes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nvv.notes to javafx.fxml;
    exports com.nvv.notes;
}