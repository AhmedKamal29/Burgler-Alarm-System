/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;

import Esper.Config;
import Events.DoorSensorReading;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kemiaa
 */
public class doorSensor extends Thread {

    private static doorSensor doorSensor;
    public int checkDoor = 0;
    private Alarm alarm;
    public int FD = 0;

    doorSensor() {

    }

    public doorSensor(Alarm alarm) {
        this.alarm = alarm;
    }

    private int random(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        checkDoor = r.nextInt((max + min) + 1) + min;
        return checkDoor;
    }

    public void CheckDoor(int checkDoor) {
        switch (checkDoor) {
            case 0:
                System.out.println("Door is Safe");
                if (FD == 1) {
                    FD = 0;
                }
                break;
            case 1:
                System.out.println("Door is Dangerous");
                if (FD == 0) {
                    FD = 1;
                }
                break;
            default:
                throw new IllegalArgumentException("doorSensor must be 0 or 1");
        }
    }

    public static doorSensor getInstance() {
        if (doorSensor == null) {
            doorSensor = new doorSensor();
        }
        return doorSensor;
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(windowSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            alarm.getDoorSensor().random(0, 1);
            Config.sendEvent(new DoorSensorReading(checkDoor));
        }
    }

}
