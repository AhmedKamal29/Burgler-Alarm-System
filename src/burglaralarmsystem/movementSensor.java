/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;

import Esper.Config;
import Events.MovementSensorReading;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kemiaa
 */
public class movementSensor extends Thread {

    private static movementSensor movementSensor;
    private Alarm alarm;
    public int checkMovement;
    public int FM = 0;

    private movementSensor() {

    }

    private int random(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        checkMovement = r.nextInt((max + min) + 1) + min;
        return checkMovement;
    }

    public void checkMovement(int checkMovement) {
        switch (checkMovement) {
            case 0:
                System.out.println("Movement is Safe");
                if (FM == 1) {
                    FM = 0;
                }
                break;
            case 1:
                System.out.println("Movemnet is Dangerous");
                if (FM == 0) {
                    FM = 1;
                }
                break;
            default:
                throw new IllegalArgumentException("CheckWindow must be 0 or 1");
        }
    }

    public movementSensor(Alarm alarm) {
        this.alarm = alarm;
    }

    public static movementSensor getInstance() {
        if (movementSensor == null) {
            movementSensor = new movementSensor();
        }
        return movementSensor;
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(windowSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            alarm.getMovementSensor().random(0, 1);
            Config.sendEvent(new MovementSensorReading(checkMovement));
        }
    }
}
