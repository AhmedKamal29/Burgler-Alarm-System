/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;

import burglaralarmsystem.Alarm;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Kemiaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Logger.getRootLogger().setLevel(Level.OFF);
        Config.registerEvents();

        final Alarm alarm = new Alarm();

        Config.createStatement("select movementReading from MovementSensorReading")
                .setSubscriber(new Object() {
                    public void update(int movementReading) throws InterruptedException {
                        alarm.movementSensorSignal(movementReading);
                    }
                });

        Config.createStatement("select windowReading from windowSensorReading")
                .setSubscriber(new Object() {
                    public void update(int windowReading) throws InterruptedException {
                        alarm.windowSensorSignal(windowReading);

                    }
                });
        Config.createStatement("select doorReading from DoorSensorReading")
                .setSubscriber(new Object() {
                    public void update(int doorReading) throws InterruptedException {
                        alarm.doorSensorSignal(doorReading);
                    }
                });
        Config.createStatement("select voltageReading from powerVoltageReading")
                .setSubscriber(new Object() {
                    public void update(int voltageReading) throws InterruptedException {
                        alarm.voltageSignal();

                    }
                });

        Config.createStatement("select state from PanicEvent")
                .setSubscriber(new Object() {
                    public void update(boolean state) throws InterruptedException {
                        alarm.setState(state);
                    }
                });

        Config.createStatement("select state from ClearEvent")
                .setSubscriber(new Object() {
                    public void update(boolean state) throws InterruptedException {
                        alarm.setState(state);
                    }
                });

        Config.createStatement("select pin from AuthorizationEvent")
                .setSubscriber(new Object() {
                    public void update(String pin) throws InterruptedException {
                       alarm.authorized(pin);
                    }
                });
    }
}
