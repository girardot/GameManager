package game.manager.ui.controler;

import game.manager.model.Console;
import game.manager.model.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsolesControler implements Initializable {

    @FXML
    private TableView<Console> tableView = new TableView<Console>();

    @FXML
    private TextField newConsoleName = new TextField();

    ObservableList<Console> consoles = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Console ps3 = new Console("ps3");
        ps3.addGame(new Game("call of duty 5"));

        Console ps2 = new Console("ps2");
        ps2.addGame(new Game("FF10"));
        ps2.addGame(new Game("FF11"));

        consoles.add(ps2);
        consoles.add(ps3);

        tableView.setItems(consoles);
    }

    public void handleAddNewConsoleButtonAction(ActionEvent actionEvent) {
        Console newConsole = new Console(newConsoleName.getText());
        consoles.add(newConsole);
    }

}
