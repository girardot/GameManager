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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsolesControler implements Initializable {

    @FXML
    private TableView<Console> consoleTableView = new TableView<Console>();

    @FXML
    private TableView<Game> gameTableView = new TableView<Game>();

    @FXML
    private TreeView<String> consoleTreeView = new TreeView<String>();

    @FXML
    private TextField newConsoleName = new TextField();

    @FXML
    private TextField newGameTitle = new TextField();

    private Console selectedConsole = null;

    ObservableList<Console> consoles = FXCollections.observableArrayList();

    ObservableList<Game> games = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Console ps3 = new Console("ps3");
        ps3.addGame(new Game("call of duty 5"));

        Console ps2 = new Console("ps2");
        ps2.addGame(new Game("FF10"));
        ps2.addGame(new Game("FF11"));

        consoles.add(ps2);
        consoles.add(ps3);

        selectedConsole = consoles.get(0);
        games.addAll(selectedConsole.getGames());

        consoleTableView.setItems(consoles);

        refreshViews();
    }

    private void refreshViews() {
        refreshTreeView();
        refreshGameTableView();
    }

    public void refreshTreeView() {
        TreeItem<String> root = new TreeItem<>("Consoles");
        for (Console console : consoles) {
            TreeItem<String> consoleTreeItem = new TreeItem<>(console.getName());
            root.getChildren().add(consoleTreeItem);

            for (Game game : console.getGames()) {
                TreeItem<String> gameTreeItem = new TreeItem<>(game.getTitle());
                consoleTreeItem.getChildren().add(gameTreeItem);
            }

        }
        consoleTreeView.setRoot(root);
    }

    public void refreshGameTableView() {
        gameTableView.setItems(games);
    }

    public void handleAddNewConsoleButtonAction(ActionEvent actionEvent) {
        Console newConsole = new Console(newConsoleName.getText());
        consoles.add(newConsole);
        refreshTreeView();
    }

    public void handleAddNewGameButtonAction(ActionEvent actionEvent) {
        Game newGame = new Game(newGameTitle.getText());
        games.add(newGame);
        selectedConsole.addGame(newGame);
        refreshViews();
    }

    public void displayConsoleGames(ActionEvent actionEvent) {
        games.clear();
        TableView.TableViewSelectionModel<Console> selectionModel = consoleTableView.getSelectionModel();
        selectedConsole = selectionModel.getSelectedItem();
        games.addAll(selectedConsole.getGames());
        refreshViews();
    }

}
