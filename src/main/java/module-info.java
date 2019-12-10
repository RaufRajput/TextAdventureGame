module se.iths.teamsmurf {
    requires javafx.controls;
    requires javafx.fxml;
    opens se.iths.teamsmurf to javafx.graphics, javafx.fxml;
}