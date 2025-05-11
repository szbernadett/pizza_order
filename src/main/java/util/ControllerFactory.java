/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import controller.BaseController;
import controller.CheeseTypePaneController;
import controller.CrustTypePaneController;
import controller.OrderDetailsPaneController;
import controller.SauceTypePaneController;
import controller.SizePaneController;
import controller.ToppingsPaneController;
import controller.WelcomePaneController;
import javafx.fxml.Initializable;

/**
 *
 * @author igbin
 */

public class ControllerFactory {

    public static BaseController create(String fxmlPath, SelectionState selectionState) {
        return switch (fxmlPath) {
            case "/view/welcome_pane.fxml" -> new WelcomePaneController();
            case "/view/size_pane.fxml" -> new SizePaneController(selectionState);
            case "/view/crust_type_pane.fxml" -> new CrustTypePaneController(selectionState);
            case "/view/sauce_type_pane.fxml" -> new SauceTypePaneController(selectionState);
            case "/view/cheese_type_pane.fxml" -> new CheeseTypePaneController(selectionState);
            case "/view/toppings_pane.fxml" -> new ToppingsPaneController(selectionState);
            case "/view/order_details_pane.fxml" -> new OrderDetailsPaneController();
            default -> throw new IllegalArgumentException("Unknown FXML path: " + fxmlPath);
        };
    }
}


