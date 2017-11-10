import Model.DatabaseConnection;
import Model.ITEMS;
import Model.ITEMSService;
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
import javafx.scene.control.TableColumn;
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

        ObservableList<items> Item = FXCollections.observableArrayList(
                new items("SS Tee", "Short Sleeve TShirt", "1", "20", "20"),
                new items("LS Tee", "Long Sleeve TShirt", "1", "25", "25"),
                new items("Coat", "Black Coat", "1", "100", "100"),
                new items("Hoodie", "Black Hoodie", "1", "70", "70"),
                new items("Trousers", "Black Trousers", "1", "50", "50")
        );

        TableView table = new TableView<>();
        table.setPrefSize(500, 200);
        table.setItems(Item);
        table.setLayoutX(55);
        table.setLayoutY(100);


        TableColumn itemNameColumn = new TableColumn<>("Item Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        //table.getColumns().add(itemNameColumn);

        TableColumn itemDescColumn = new TableColumn<>("Item Description");
        itemDescColumn.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
        //table.getColumns().add(itemDescColumn);

        TableColumn QuantityColumn = new TableColumn<>("Quantity");
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        //table.getColumns().add(QuantityColumn);

        TableColumn unitPriceColumn = new TableColumn<>("Unit Price");
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        //table.getColumns().add(unitPriceColumn);

        TableColumn totalPriceColumn = new TableColumn<>("Total Price");
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        //table.getColumns().add(totalPriceColumn);

        table.getColumns().addAll(itemNameColumn, itemDescColumn, QuantityColumn, unitPriceColumn, totalPriceColumn);

        root.getChildren().add(table);

        ArrayList<ITEMS> testList = new ArrayList<>();
        ITEMSService.selectAll(testList, database);
        for (ITEMS c : testList) {
            System.out.println(c);
        }
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