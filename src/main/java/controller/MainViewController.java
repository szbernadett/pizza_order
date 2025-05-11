/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import model.Pizza;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class MainViewController {
    @FXML private StackPane contentStackPane;
    @FXML private Button backBtn;
    @FXML private Button nextBtn;

    private final SelectionState state = new SelectionState();
    private final Pizza.Builder pizzaBuilder = new Pizza.Builder();

    private final List<Step> steps = new ArrayList<>();
    private int currentStepIndex = 0;
   


    @FXML
    public void initialize() {
        
        try {
            loadSteps();
            showStep(0);
        } catch (IOException e) {
            e.printStackTrace(); // Replace with dialog/log
        }
    }

    private void loadSteps() throws IOException {
        steps.add(loadStep("/view/welcomePane.fxml", null));
        steps.add(loadStep("/view/sizePane.fxml", controller -> ((SizePaneController) controller).setSelectedValue(state.size)));
        steps.add(loadStep("/view/crustTypePane.fxml", controller -> ((CrustTypePaneController) controller).setSelectedValue(state.crust)));
        steps.add(loadStep("/view/sauceTypePane.fxml", controller -> ((SauceTypePaneController) controller).setSelectedValue(state.sauce)));
        steps.add(loadStep("/view/toppingsPane.fxml", controller -> ((ToppingsPaneController) controller).restoreSelections()));
        steps.add(loadStep("/view/cheeseTypePane.fxml", controller -> ((CheeseTypePaneController) controller).setSelectedValue(state.cheese)));
        steps.add(loadStep("/view/orderDetailsPane.fxml", controller -> {
            ((OrderDetailsPaneController) controller).setPizza(pizzaBuilder.build());
        }));
    }

    private Step loadStep(String fxmlPath, StepInitialiser initialiser) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Node pane = loader.load();
        StatefulController controller = loader.getController();
        if (initialiser != null) initialiser.init(controller);
        return new Step(pane, controller);
    }

    private void showStep(int index) {
        contentStackPane.getChildren().setAll(steps.get(index).pane());
        backBtn.setDisable(index == 0);
        nextBtn.setText(index == steps.size() - 1 ? "Finish" : "Next");
    }

    @FXML
    private void onBackButtonClick() {
        saveCurrentStep();
        if (currentStepIndex > 0) {
            currentStepIndex--;
            showStep(currentStepIndex);
        }
    }

    @FXML
    private void onNextButtonClick() {
        saveCurrentStep();
        if (currentStepIndex < steps.size() - 1) {
            currentStepIndex++;
            showStep(currentStepIndex);
        } else {
            System.out.println("Pizza built: " + pizzaBuilder.build());
        }
    }

    private void saveCurrentStep() {
        StatefulController controller = (StatefulController) steps.get(currentStepIndex).controller();
            controller.saveTo(state);
    }

    private record Step(Node pane, Object controller) {}
    private interface StepInitialiser {
        void init(Object controller);
    }
}
