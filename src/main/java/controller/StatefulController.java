/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import util.SelectionState;

/**
 *
 * @author igbin
 */
public interface StatefulController {
    void saveTo(SelectionState state);
    void loadFrom(SelectionState state);
}
