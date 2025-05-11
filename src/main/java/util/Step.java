/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import controller.BaseController;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import state.ApplicationState;

/**
 *
 * @author igbin
 */
public class Step {
   private final Node pane;
    private final BaseController controller;
    private final Class<? extends ApplicationState> stateClass;

    public Step(Node pane, BaseController controller, Class<? extends ApplicationState> stateClass) {
        this.pane = pane;
        this.controller = controller;
        this.stateClass = stateClass;
    }

    public Node getPane() {
        return pane;
    }

    public BaseController getController() {
        return controller;
    }

    public Class<? extends ApplicationState> getStateClass() {
        return stateClass;
    }
}
