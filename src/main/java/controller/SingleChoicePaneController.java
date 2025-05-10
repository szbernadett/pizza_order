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
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import util.AccessibilityHelper;

/**
 *
 * @author igbin
 */
public abstract class SingleChoicePaneController<T extends Enum<T>> implements Initializable {
    @FXML
    protected VBox optionsBox;

    protected final ToggleGroup toggleGroup = new ToggleGroup();
    protected final Map<T, RadioButton> radioButtons = new LinkedHashMap<>();

    protected T selectedValue;

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
        restoreSelection();
    }

    public void saveSelection() {
        if (toggleGroup.getSelectedToggle() != null) {
            selectedValue = (T) toggleGroup.getSelectedToggle().getUserData();
        } else {
            selectedValue = null;
        }
    }

    public void restoreSelection() {
        if (selectedValue != null && radioButtons.containsKey(selectedValue)) {
            radioButtons.get(selectedValue).setSelected(true);
        }
    }

    public void setSelectedValue(T value) {
        this.selectedValue = value;
        restoreSelection();
    }

    public T getSelectedValue() {
        return selectedValue;
    }


}
