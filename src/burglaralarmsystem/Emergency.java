/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;

import Esper.Config;
import Events.powerVoltageReading;
import View.AlarmGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kemiaa
 */
public class Emergency extends Thread {

    private final Alarm alarm;

    public Emergency(Alarm alarm) {
        this.alarm = alarm;
    }

    void callPolice() throws InterruptedException {
        System.out.println("Call the police");
    }

    void LightsOn() throws InterruptedException {
        System.out.println("Turning Lights On");
    }

    void LightsOff() throws InterruptedException {
        System.out.println("Turning Lights Off");
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(windowSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
