/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import util.AccessibilityHelper;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public abstract class SingleChoicePaneController<T extends Enum<T>> extends StatefulController  {
    @FXML
    protected VBox optionsBox;

    protected final ToggleGroup toggleGroup = new ToggleGroup();
    protected final Map<T, RadioButton> radioButtons = new LinkedHashMap<>();

    protected T selectedValue;

    public SingleChoicePaneController(SelectionState selectionState) {
        super(selectionState);
    }

    protected abstract Class<T> getEnumClass();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (T value : getEnumClass().getEnumConstants()) {
            RadioButton rb = new RadioButton(value.toString());
            rb.setToggleGroup(toggleGroup);
            rb.setUserData(value);
            radioButtons.put(value, rb);
            optionsBox.getChildren().add(rb);
        }
        
        AccessibilityHelper.enhanceControls(new ArrayList<>(radioButtons.values()));
        
    }


    public void setSelectedValue(T value) {
        this.selectedValue = value;
    }

    public T getSelectedValue() {
        return selectedValue;
    }


}
