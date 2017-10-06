import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();

        Scene scene = new Scene(root, 600, 400);
        stage.setResizable(false);
        stage.setTitle("Stock Control");
        stage.setScene(scene);
        stage.show();



        VBox rooted = new VBox();
        MenuBar myMenu = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem fileItem1 = new MenuItem("New");
        MenuItem fileItem2 = new MenuItem("Open");
        MenuItem fileItem3 = new MenuItem("Save");
        fileMenu.getItems().addAll(fileItem1, fileItem2, fileItem3);
        fileItem3.setOnAction(((ActionEvent ae) -> save()));

        Menu editMenu = new Menu("Edit");
        MenuItem editItem1 = new MenuItem("Preferences");
        MenuItem editItem2 = new MenuItem("Copy");
        MenuItem editItem3 = new MenuItem("Paste");
        MenuItem editItem4 = new MenuItem("Delete");
        editMenu.getItems().addAll(editItem1, editItem2, editItem3, editItem4);
        editItem1.setOnAction((ActionEvent ae) -> openStageThree(root));

        Menu helpMenu = new Menu("Help");
        MenuItem helpItem1 = new MenuItem("Register");
        MenuItem helpItem2 = new MenuItem("Check For Updates");
        MenuItem helpItem3 = new MenuItem("About");
        helpMenu.getItems().addAll(helpItem1, helpItem2, helpItem3);
        helpItem3.setOnAction((ActionEvent ae) -> openStageTwo(root));

        myMenu.getMenus().addAll(fileMenu, editMenu, helpMenu);
        root.getChildren().add(myMenu);

    }
    public static void openStageOne(Pane pane) {
        StageOne newStageOne = new StageOne(pane);
    }

    public static void openStageTwo(Pane pane) {
        StageTwo newStageTwo = new StageTwo(pane);
    }

    public static void openStageThree(Pane pane) {
        StageThree newStageThree = new StageThree(pane);
    }

    public static void save() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("File has been saved.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}