/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import View.AlarmGUI;

/**
 *
 * @author Kemiaa
 */
public class ClearEvent {

    private AlarmGUI gui;
    boolean state;

    public ClearEvent(boolean state) {
        this.state = state;
        //gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
    }

    public boolean getState() {
        return state;
    }

}
