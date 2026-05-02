import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        TextField idField = new TextField();
        idField.setPromptText("ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        TextField resIdField = new TextField();
        resIdField.setPromptText("Restaurant ID");

        Button insertBtn = new Button("Insert Item");
        Button viewBtn = new Button("View Items");
        Button updateBtn = new Button("Update Price");
        Button deleteBtn = new Button("Delete Item");

        TextArea output = new TextArea();

        // Insert
        insertBtn.setOnAction(e -> {
            MenuItemDAO.insertItem(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    Double.parseDouble(priceField.getText()),
                    Integer.parseInt(resIdField.getText())
            );
            output.setText("Item Inserted!");
        });

        // View
        viewBtn.setOnAction(e -> {
            output.setText("Check console for output");
            MenuItemDAO.viewItems();
        });

        // Update
        updateBtn.setOnAction(e -> {
            MenuItemDAO.updatePrice(
                    Integer.parseInt(idField.getText()),
                    Double.parseDouble(priceField.getText())
            );
            output.setText("Updated!");
        });

        // Delete
        deleteBtn.setOnAction(e -> {
            MenuItemDAO.deleteItem(Integer.parseInt(idField.getText()));
            output.setText("Deleted!");
        });

        VBox layout = new VBox(10,
                idField, nameField, priceField, resIdField,
                insertBtn, viewBtn, updateBtn, deleteBtn,
                output);

        Scene scene = new Scene(layout, 400, 500);
        stage.setTitle("Menu Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}