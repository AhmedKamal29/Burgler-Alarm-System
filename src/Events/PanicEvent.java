/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

/**
 *
 * @author Kemiaa
 */
import View.AlarmGUI;

public class PanicEvent {

    private AlarmGUI gui;
    boolean state;

    public PanicEvent(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

}
