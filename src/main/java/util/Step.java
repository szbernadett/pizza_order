/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import controller.BaseController;
import javafx.scene.Node;
import state.ApplicationState.StateName;

/**
 *
 * @author igbin
 */
public class Step {
   private final Node pane;
    private final BaseController controller;
    private final StateName appStateName;

    public Step(Node pane, BaseController controller, StateName appStateName) {
        this.pane = pane;
        this.controller = controller;
        this.appStateName = appStateName;
    }

    public Node getPane() {
        return pane;
    }

    public BaseController getController() {
        return controller;
    }

    public StateName getAppStateName() {
        return appStateName;
    }
}
