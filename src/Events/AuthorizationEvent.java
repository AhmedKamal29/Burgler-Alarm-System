/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import View.AlarmGUI;
import javax.swing.JLabel;

/**
 *
 * @author Kemiaa
 */
public class AuthorizationEvent {

    private AlarmGUI gui;
    boolean state;
    char[] password;
    String pin;

    public AuthorizationEvent(boolean state) {
        this.state = state;
        //gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
    }

    public AuthorizationEvent(char[] password) {
        this.password = password;
        pin = String.copyValueOf(this.password);
    }

    public boolean getState() {
        return state;
    }
    
    public String getPin() {
        return pin;
    }
}
