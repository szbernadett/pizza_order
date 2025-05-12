/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.control.Labeled;

/**
 *
 * @author igbin
 */


public class AccessibilityHelper {

/**
     * Assigns unique mnemonics to a list of Labeled controls (e.g. RadioButtons, CheckBoxes).
     * Sets mnemonics for shorter labels first to give them a better chance to have an available
     * character that has not been assigned to another label within the group.
     * Sets accessibleText.
     */
    public static void enhanceControls(List<? extends Labeled> controls) {
        Set<Character> usedMnemonics = new HashSet<>();
        System.out.println("controls in this method: " + controls);

        // Sort controls by label length (shorter = higher priority)
        controls.sort(Comparator.comparing(c -> c.getText().length()));

        for (Labeled control : controls) {
            String text = control.getText();
            if (text == null || text.isEmpty()) continue;

            String lower = text.toLowerCase();
            boolean assigned = false;

            for (int i = 0; i < lower.length(); i++) {
                char ch = lower.charAt(i);
                if (Character.isLetter(ch) && !usedMnemonics.contains(ch)) {
                    usedMnemonics.add(ch);

                    // Insert _ before the chosen mnemonic character
                    StringBuilder newText = new StringBuilder(text);
                    newText.insert(i, '_');

                    control.setMnemonicParsing(true);
                    control.setText(newText.toString());

                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                // Could not assign a unique mnemonic
                control.setMnemonicParsing(false);
            }

            // Add descriptive accessibility text
            control.setAccessibleText("Toggle " + text.toLowerCase() + " option");
        }
    }
}
