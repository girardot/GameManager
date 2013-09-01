package game.manager.ui.controler;

import game.manager.model.Console;
import game.manager.model.Game;
import game.manager.service.ConsoleService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ConsolesControler implements Initializable {

    @FXML
    private TableView<Console> consoleTableView = new TableView<Console>();

    @FXML
    private TableView<Game> gameTableView = new TableView<Game>();

    @FXML
    private TreeView<String> consoleTreeView = new TreeView<String>();

    @FXML
    private TextField newConsoleNameField = new TextField();

    @FXML
    private TextField newGameTitleField = new TextField();

    private ObservableList<Console> consoles = FXCollections.observableArrayList();

    private ObservableList<Game> games = FXCollections.observableArrayList();

    private Console selectedConsole = null;

    @Inject
    private ConsoleService consoleService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();

        selectedConsole = consoles.get(0);
        games.addAll(selectedConsole.getGames());

        consoleTableView.setItems(consoles);

        refreshViews();
    }

    private void loadData() {
        consoles.addAll(consoleService.findAll());
    }

    //refresh methods
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

    //action button methods
    public void handleAddNewConsoleButtonAction(ActionEvent actionEvent) {
        Console newConsole = new Console(newConsoleNameField.getText());
        consoles.add(newConsole);
        refreshTreeView();
    }

    public void handleAddNewGameButtonAction(ActionEvent actionEvent) {
        Game newGame = new Game(newGameTitleField.getText());
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

    public void saveButtonAction(ActionEvent actionEvent) {
        //TODO
    }
}
