import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StageThree {

    static Pane parent;

    public StageThree(Pane theParent) {

        Stage stage = new Stage();
        parent = theParent;
        parent.setDisable(true);
        start(stage);

    }

    public void start(Stage stage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Preferences");
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
        stage.show();
        stage.setResizable(false);
    }

    public void closeStage(Stage stage) {

        parent.setDisable(false);
        stage.close();

    }

}