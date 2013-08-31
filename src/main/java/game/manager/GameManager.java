package game.manager;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameManager extends Application {

    private static final SpringFxmlLoader loader = new SpringFxmlLoader();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent) loader.load("/fxml/ConsolesView.fxml");
        primaryStage.setTitle("GameManagerFx");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
