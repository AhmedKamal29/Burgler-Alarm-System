/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;

import Esper.Config;
import Events.powerVoltageReading;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kemiaa
 */
public class powerVoltage extends Thread {

    private final Alarm alarm;
    public int voltageValue;

    public powerVoltage(Alarm alarm) {
        this.alarm = alarm;
        this.voltageValue = 100;
    }

    private int random(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void idle() {
        if (voltageValue < 80) {
            voltageValue += random(2, 5);
            System.out.println(voltageValue);

        } else {
            voltageValue -= random(2, 5);
            System.out.println(voltageValue);
        }
    }

    public void lowVoltage() {
        voltageValue -= random(10, 15);
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(windowSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            alarm.getPowerVoltage().random(0, 1);
            Config.sendEvent(new powerVoltageReading(voltageValue));
        }
    }

}
