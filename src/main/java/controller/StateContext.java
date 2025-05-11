/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.Optional;
import javafx.fxml.Initializable;
import state.ApplicationState;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public interface StateContext {
    void setApplicationState(ApplicationState state);
    ApplicationState getApplicationState();
    public boolean hasNextStep();
    public boolean isStepInState(Class<? extends ApplicationState> stateClass, int stepIndex);
    public void showNextStep();
    public void showCurrentStep();
    public void showPreviousStep();
    public Optional<BaseController> getControllerForState(Class<? extends ApplicationState> stateClass);
    public SelectionState getSelectionState();
    public int getCurrentStepIndex();
}
