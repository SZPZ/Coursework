import Model.DatabaseConnection;
import Model.ITEMS;
import Model.ITEMSService;
import Model.ITEMSView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

import java.util.ArrayList;


public class main extends Application {
    public static DatabaseConnection database;
    @Override
    public void start(Stage stage) throws Exception {

        database = new DatabaseConnection("Coursework.db");
        Pane root = new Pane();

        Scene scene = new Scene(root, 600, 400);
        stage.setResizable(false);
        stage.setTitle("Stock Control");
        stage.setScene(scene);
        stage.show();


        VBox rooted = new VBox();
        MenuBar myMenu = new MenuBar();

        //Menu fileMenu = new Menu("File");
        //MenuItem fileItem1 = new MenuItem("New");
        //MenuItem fileItem2 = new MenuItem("Open");
        //MenuItem fileItem3 = new MenuItem("Save");
        //fileMenu.getItems().addAll(fileItem1, fileItem2, fileItem3);
        //fileItem3.setOnAction(((ActionEvent ae) -> save()));

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

        myMenu.getMenus().addAll(editMenu, helpMenu);
        root.getChildren().add(myMenu);

        Button myButton = new Button("Add");
        myButton.setPrefSize(70, 10);
        myButton.setLayoutX(480);
        myButton.setLayoutY(50);
        myButton.setOnAction((ActionEvent ae) -> openStageFour(root));
        root.getChildren().add(myButton);

        TableView<ITEMSView> table = new TableView<>();
        table.setPrefSize(500, 200);
        table.setLayoutX(55);
        table.setLayoutY(100);

        ArrayList<ITEMS> itemsList = new ArrayList<>();
        ITEMSService.selectAll(itemsList, database);

        ArrayList<ITEMSView> itemsViewList = new ArrayList<>();
        for (ITEMS i : itemsList) {
            itemsViewList.add(new ITEMSView(i));
        }

        ObservableList<ITEMSView> observableList = FXCollections.observableArrayList(itemsViewList);

        table.setItems(observableList);

        TableColumn<ITEMSView, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        table.getColumns().add(column1);

        TableColumn<ITEMSView, String> column2 = new TableColumn<>("Description");
        column2.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
        table.getColumns().add(column2);

        TableColumn<ITEMSView, Integer> column3 = new TableColumn<>("Quantity");
        column3.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        table.getColumns().add(column3);

        TableColumn<ITEMSView, Integer> column4 = new TableColumn<>("Price");
        column4.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.getColumns().add(column4);

        TableColumn<ITEMSView, Integer> column5 = new TableColumn<>("Total");
        column5.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        table.getColumns().add(column5);

        root.getChildren().add(table);

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

    public static void openStageFour(Pane pane) { StageFour newStageFour = new StageFour(pane);
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