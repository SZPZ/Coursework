import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StageFour {

    static Pane parent;

    public StageFour(Pane theParent) {

        Stage stage = new Stage();
        parent = theParent;
        parent.setDisable(true);
        start(stage);

    }

    public void start(Stage stage) {

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 350, 200);
        stage.setTitle("Add");
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
        stage.setResizable(false);

        // text box
        final TextField textField = new TextField("Name");
        GridPane.setConstraints(textField, 1, 1);
        root.getChildren().add(textField);

        final TextField textFieldTwo = new TextField("Description");
        GridPane.setConstraints(textFieldTwo, 1, 2);
        root.getChildren().add(textFieldTwo);

        final TextField textFieldThree = new TextField("Quantity");
        GridPane.setConstraints(textFieldThree, 1, 3);
        root.getChildren().add(textFieldThree);

        final TextField textFieldFour = new TextField("Price");
        GridPane.setConstraints(textFieldFour, 1, 4);
        root.getChildren().add(textFieldFour);

        final TextField textFieldFive = new TextField("Total");
        GridPane.setConstraints(textFieldFive, 1, 5);
        root.getChildren().add(textFieldFive);

        Button myButton = new Button("Add");
        myButton.setPrefSize(70, 10);
        GridPane.setConstraints(myButton, 2, 5);
        //myButton.setOnAction((ActionEvent ae) -> action(root));
        root.getChildren().add(myButton);
        // finally...
        stage.show();
    }

    public void closeStage(Stage stage) {

        parent.setDisable(false);
        stage.close();

    }

}