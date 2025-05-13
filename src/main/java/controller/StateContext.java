/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.Optional;
import state.ApplicationState;
import state.ApplicationState.StateName;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public interface StateContext {
    void setApplicationState(ApplicationState state);
    ApplicationState getApplicationState();
    public boolean hasNextStep();
    public boolean isStepInState(StateName appStateName, int stepIndex);
    public void showNextStep();
    public void showCurrentStep();
    public void showPreviousStep();
    public Optional<BaseController> getControllerForState(StateName appStateName);
    public SelectionState getSelectionState();
    public int getCurrentStepIndex();
    public void closeApp();
}
