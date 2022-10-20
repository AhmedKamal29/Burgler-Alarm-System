/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;

/**
 *
 * @author Kemiaa
 */
public class ledLight {

    private Alarm alarm;
    private boolean state;

    public ledLight(Alarm alarm) {
        this.state = false;
        this.alarm = alarm;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
