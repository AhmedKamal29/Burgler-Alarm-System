/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;

import Esper.Config;
import Events.windowSensorReading;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kemiaa
 */
public class windowSensor extends Thread {

    private static windowSensor windowSensor;
    public int checkWindow = 0;
    private Alarm alarm;
    public int FW = 0;

    public windowSensor() {

    }

    public static windowSensor getInstance() {
        if (windowSensor == null) {
            windowSensor = new windowSensor();
        }
        return windowSensor;
    }

    public windowSensor(Alarm alarm) {
        this.alarm = alarm;
    }

    private int random(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        checkWindow = r.nextInt((max + min) + 1) + min;
        return checkWindow;
    }

    public void CheckWindow(int checkWindow) {
        switch (checkWindow) {
            case 0:
                System.out.println("Window is Safe");
                if (FW == 1) {
                    FW = 0;
                }
                break;
            case 1:
                System.out.println("Window is Dangerous");
                if (FW == 0) {
                    FW = 1;
                }
                break;
            default:
                throw new IllegalArgumentException("CheckWindow must be 0 or 1");
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(windowSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            alarm.getWindowSensor().random(0, 1);
            Config.sendEvent(new windowSensorReading(checkWindow));
        }
    }
}
