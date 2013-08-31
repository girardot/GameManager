package game.manager.ui.controler;

import game.manager.model.Console;
import game.manager.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsolesControler implements Initializable {

    @FXML
    private TableView<Console> tableView = new TableView<Console>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Console ps3 = new Console("ps3");
        ps3.addGame(new Game("call of duty 5"));
        Console ps2 = new Console("ps2");
        ps2.addGame(new Game("FF10"));
        ps2.addGame(new Game("FF11"));
        tableView.getItems().add(ps3);
        tableView.getItems().add(ps2);
    }

}
