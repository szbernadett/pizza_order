/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import state.ApplicationState;
import state.ApplicationState.StateName;
import state.GreetingState;
import util.ControllerFactory;
import util.SelectionState;
import util.Step;

/**
 *
 * @author igbin
 */
public class MainViewController implements Initializable, StateContext {
    @FXML private StackPane stepContainer;
    @FXML private Button backBtn;
    @FXML private Button nextBtn;

    private final List<String> fxmlSteps = List.of(
            "/view/welcome_pane.fxml",
            "/view/size_pane.fxml",
            "/view/crust_type_pane.fxml",
            "/view/sauce_type_pane.fxml",
            "/view/cheese_type_pane.fxml",
            "/view/toppings_pane.fxml",
            "/view/order_details_pane.fxml"
    );

    private final List<Step> steps = new ArrayList<>();
    private int currentStepIndex = 0;

    private ApplicationState state;
    private final SelectionState selectionState = SelectionState.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backBtn.addEventHandler(ActionEvent.ACTION, this::onBackButtonClick);
        nextBtn.addEventHandler(ActionEvent.ACTION, this::onNextButtonClick);
        
        try {
            for (int i = 0; i < fxmlSteps.size(); i++) {
                BaseController controller = ControllerFactory.create(fxmlSteps.get(i), selectionState);
                switch(i){
                    case 0:
                        steps.add(loadStep(fxmlSteps.get(i), controller, StateName.GREETING));
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        steps.add(loadStep(fxmlSteps.get(i), controller, StateName.PIZZA_CREATION));
                        break;
                    case 6:
                        steps.add(loadStep(fxmlSteps.get(i), controller, StateName.ORDER_CONRIMATION));
                    default:
                        break;
                }
            }
        } catch (IOException e) {
                System.out.println("Failed to load files necessary to run the application.");
                e.printStackTrace();
        }

        setApplicationState(new GreetingState(this, StateName.GREETING));
        Platform.runLater(() -> { showCurrentStep(); }); 
    }

    private Step loadStep(String fxmlPath, BaseController controller, StateName appStateName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setController(controller);
        Node pane = loader.load();
        return new Step(pane, controller, appStateName);
    }


    @Override
    public Optional<BaseController> getControllerForState(StateName appStateName) {
        for (Step step : steps) {
            if(step.getAppStateName().equals(appStateName)){
                return Optional.of(step.getController());
            }
        }
        
        return Optional.of(null);
    }

    @Override
    public boolean hasNextStep() {
        return currentStepIndex + 1 < steps.size();
    }

    @Override
    public boolean isStepInState(StateName appStateName, int stepIndex) {
        if (stepIndex >= steps.size() || stepIndex < 0) return false;
        return steps.get(stepIndex).getAppStateName().equals(appStateName);
    }

    @Override
    public void showNextStep() {
        if (hasNextStep()) {
            currentStepIndex++;
            showCurrentStep();
        }
    }

    @Override
    public void showPreviousStep() {
        if (currentStepIndex > 0) {
            currentStepIndex--;
            showCurrentStep();
        }
    }

    @Override
    public void showCurrentStep() {
        Step current = steps.get(currentStepIndex);
        stepContainer.getChildren().setAll(current.getPane());
        BaseController controller = current.getController();
        controller.updateView();
        StateName appStateName = current.getAppStateName();
        backBtn.setDisable(appStateName.equals(StateName.GREETING));
        if (appStateName.equals(StateName.PIZZA_CREATION)) {
            StatefulController stateful = (StatefulController) controller;
            stateful.loadFrom();
        } else if(appStateName.equals(StateName.ORDER_CONRIMATION)) {
            nextBtn.setText("Exit");
        }
    }

    private void onNextButtonClick(ActionEvent event) {
        Step current = steps.get(currentStepIndex);
        if (current.getAppStateName().equals(StateName.PIZZA_CREATION)) {
            StatefulController stateful = (StatefulController) current.getController();
            stateful.saveTo();
        }
        state.onNext();
    }

    private void onBackButtonClick(ActionEvent event) {
        Step current = steps.get(currentStepIndex);
        if (current.getAppStateName().equals(StateName.PIZZA_CREATION)) {
            StatefulController stateful = (StatefulController) current.getController();
            stateful.saveTo();
        }
        state.onBack();
    }
    
    @Override
    public void closeApp(){
        Stage stage = (Stage) nextBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void setApplicationState(ApplicationState state) {
        this.state = state;
        System.out.println("Application in state: " + state.getClass().getName());
    }

    @Override
    public ApplicationState getApplicationState() {
        return this.state;
    }

    @Override
    public SelectionState getSelectionState() {
        return this.selectionState;
    }

    @Override
    public int getCurrentStepIndex() {
        return currentStepIndex;
    }


 
}
