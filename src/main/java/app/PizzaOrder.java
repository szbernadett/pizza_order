/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

import controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author igbin
 */
public class PizzaOrder extends Application {

    public static void main(String[] args) {
        launch(args);
     }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));

        // Set the controller programmatically
        loader.setController(new MainViewController());

        Parent root = loader.load();

        stage.setTitle("Pizza Ordering App");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
