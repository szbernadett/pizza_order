/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import model.Topping;
import util.AccessibilityHelper;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class ToppingsPaneController extends StatefulController implements BaseController {
    
    @FXML private GridPane toppingsGrid;
    private final List<Topping> selectedToppings = new ArrayList<>();
    private final Map<Topping, CheckBox> checkBoxMap = new HashMap<>();

    public ToppingsPaneController(SelectionState selectionState) {
        super(selectionState);
    }

        public void updateView(){
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Topping[] toppings = Topping.values();
        int total = toppings.length;
        int columns = 2;
        int rows = (int) Math.ceil((double) total / columns);
        
        for (int i = 0; i < total; i++) {
            Topping topping = toppings[i];
            CheckBox cb = new CheckBox(topping.toString());
            cb.setUserData(topping);
            cb.selectedProperty().addListener(this::checkBoxSelected);
            if(selectedToppings.contains(topping)){
                cb.setSelected(true);
            }
            
            checkBoxMap.put(topping, cb);
            
            int col = i / rows;
            int row = i % rows;
            toppingsGrid.add(cb, col, row);
            
        }
        
            AccessibilityHelper.enhanceControls(new ArrayList<>(checkBoxMap.values()));

    }

    
    private  void checkBoxSelected(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(newValue){
            for(Map.Entry<Topping, CheckBox> entry : checkBoxMap.entrySet()) {
                if(entry.getValue().equals((CheckBox) ((ReadOnlyProperty<?>) observable).getBean())){
                    selectedToppings.add(entry.getKey());
                }
            }
         
        } else {
            for(Map.Entry<Topping, CheckBox> entry : checkBoxMap.entrySet()) {
                if(entry.getValue().equals((CheckBox) ((ReadOnlyProperty<?>) observable).getBean())){
                    selectedToppings.remove(entry.getKey());
                }
            }
        }
    }
    
    public void restoreSelection() {
        for(Map.Entry<Topping, CheckBox> entry : checkBoxMap.entrySet())
        {
            entry.getValue().setSelected(selectedToppings.contains(entry.getKey()));
        }
    }
    
    public List<Topping> getSelectedToppings(){
        return selectedToppings;
    }
    
    public void setSelectedToppings(List<Topping> toppings) {
        selectedToppings.clear();
        if (toppings != null) {
            selectedToppings.addAll(toppings);
        }
        restoreSelection();
    }
    
     @Override
    public void saveTo() {
        selectionState.toppings = new ArrayList(getSelectedToppings());
    }

    @Override
    public void loadFrom() {
        setSelectedToppings(selectionState.toppings);
    }

}
