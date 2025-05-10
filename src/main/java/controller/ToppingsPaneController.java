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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import model.Topping;
import util.AccessibilityHelper;

/**
 *
 * @author igbin
 */
public class ToppingsPaneController implements Initializable {
    
    @FXML private GridPane toppingsGrid;
    private final List<Topping> selectedToppings = new ArrayList<>();
    private final Map<Topping, CheckBox> checkBoxMap = new HashMap<>();

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
    
    public void saveSelections(){
        selectedToppings.clear();
        for(Map.Entry<Topping, CheckBox> entry : checkBoxMap.entrySet()){
            if (entry.getValue().isSelected()) {
                selectedToppings.add(entry.getKey());
            }
        
        }
    }
    
    public void restoreSelections() {
        for(Map.Entry<Topping, CheckBox> entry : checkBoxMap.entrySet()) {
            entry.getValue().setSelected(selectedToppings.contains(entry.getKey()));
        }
    }
    
    public List<Topping> getSelectedToppings(){
        return selectedToppings;
    }
    
}
