/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;

import static java.lang.Boolean.TRUE;
import View.AlarmGUI;
import java.awt.Color;

/**
 *
 * @author Kemiaa
 */
public class Alarm {

    private boolean state = TRUE;
    private doorSensor doorSensor;
    private windowSensor windowSensor;
    private movementSensor movementSensor;
    private powerVoltage powerVoltage;
    private circuitMonitor circuitMonitor;
    private Emergency emergency;
    private AlarmGUI gui;
    private ledLight ledLight;

    public Alarm() {

        gui = new AlarmGUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);

        doorSensor = new doorSensor(this);
        windowSensor = new windowSensor(this);
        movementSensor = new movementSensor(this);
        powerVoltage = new powerVoltage(this);
        emergency = new Emergency(this);
        ledLight = new ledLight(this);
        movementSensor.start();
        windowSensor.start();
        doorSensor.start();
        powerVoltage.start();
        emergency.start();

    }

    public void windowSensorSignal(int signal) throws InterruptedException {

        windowSensor.CheckWindow(signal);
        if (windowSensor.FW == 1) {
            gui.getWindowBtn().setBackground(new java.awt.Color(102, 0, 0));
        } else {
            gui.getWindowBtn().setBackground(new java.awt.Color(51, 102, 0));
        }
        if (this.checkSingals(doorSensor.FD, windowSensor.FW, movementSensor.FM) == TRUE) {
            emergency.callPolice();
            gui.getDisplayText().setText("Calling the Police !!!");
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
            Thread.sleep(1000);
            gui.getDisplayText().setText(" ");
            doorSensor.FD = 0;
            windowSensor.FW = 0;
            movementSensor.FM = 0;
        }

        if (this.LightHandling(doorSensor.FD, windowSensor.FW, movementSensor.FM) == TRUE) {
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
        } else {
            gui.getLightsBtn().setBackground(new java.awt.Color(102, 0, 0));
        }

    }

    public void doorSensorSignal(int signal) throws InterruptedException {
        doorSensor.CheckDoor(signal);
        if (doorSensor.FD == 1) {
            gui.getDoorBtn().setBackground(new java.awt.Color(102, 0, 0));
        } else {
            gui.getDoorBtn().setBackground(new java.awt.Color(51, 102, 0));
        }

        if (this.checkSingals(doorSensor.FD, windowSensor.FW, movementSensor.FM) == TRUE) {
            emergency.callPolice();
            gui.getDisplayText().setText("Calling the Police !!!");
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
            Thread.sleep(1000);
            gui.getDisplayText().setText(" ");
            doorSensor.FD = 0;
            windowSensor.FW = 0;
            movementSensor.FM = 0;
        }

        if (this.LightHandling(doorSensor.FD, windowSensor.FW, movementSensor.FM) == TRUE) {
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
        } else {
            gui.getLightsBtn().setBackground(new java.awt.Color(102, 0, 0));
        }
    }

    public void movementSensorSignal(int signal) throws InterruptedException {
        movementSensor.checkMovement(signal);
        if (movementSensor.FM == 1) {
            gui.getMovmentBtn().setBackground(new java.awt.Color(102, 0, 0));
        } else {
            gui.getMovmentBtn().setBackground(new java.awt.Color(51, 102, 0));
        }

        if (this.checkSingals(doorSensor.FD, windowSensor.FW, movementSensor.FM) == TRUE) {
            emergency.callPolice();
            gui.getDisplayText().setText("Calling the Police !!!");
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
            Thread.sleep(1000);
            gui.getDisplayText().setText(" ");
            doorSensor.FD = 0;
            windowSensor.FW = 0;
            movementSensor.FM = 0;
        }

        if (this.LightHandling(doorSensor.FD, windowSensor.FW, movementSensor.FM) == TRUE) {
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));

        } else {
            gui.getLightsBtn().setBackground(new java.awt.Color(102, 0, 0));
        }
    }

    public boolean checkSingals(int FD, int FW, int FM) {
        return FD == 1 && FW == 1 || FW == 1 && FM == 1 || FM == 1 && FD == 1;
    }

    public boolean LightHandling(int FD, int FW, int FM) {
        return FD == 1 || FW == 1 || FM == 1;
    }

    public void PanicProtocol() throws InterruptedException {
        doorSensor.FD = 1;
        windowSensor.FW = 1;
        movementSensor.FM = 1;
        emergency.callPolice();
        gui.getDisplayText().setBackground(new java.awt.Color(102, 0, 0));
        gui.getDisplayText().setForeground(new java.awt.Color(0, 0, 0));
        gui.getDisplayText().setText("Activating Panic Protocol \n Calling the Police !!!");
        emergency.LightsOn();
        gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));

        if (gui.getPanicBtn().getModel().isEnabled() == TRUE) {
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getDoorBtn().setBackground(new java.awt.Color(102, 0, 0));
            gui.getMovmentBtn().setBackground(new java.awt.Color(102, 0, 0));
            gui.getWindowBtn().setBackground(new java.awt.Color(102, 0, 0));

        } else {
            gui.getLightsBtn().setBackground(new java.awt.Color(102, 0, 0));
            gui.getDoorBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getMovmentBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getWindowBtn().setBackground(new java.awt.Color(51, 102, 0));
        }

    }

    public void Clear() throws InterruptedException {
        doorSensor.FD = 0;
        windowSensor.FW = 0;
        movementSensor.FM = 0;

        emergency.LightsOff();
        gui.getLightsBtn().setBackground(new java.awt.Color(102, 0, 0));
        gui.getDisplayText().setBackground(Color.white);
        gui.getDisplayText().setForeground(new java.awt.Color(0, 0, 0));
        gui.getDisplayText().setText(" ");

        if (gui.getClearBtn().getModel().isEnabled() == TRUE) {
            gui.getLightsBtn().setBackground(new java.awt.Color(102, 0, 0));
            gui.getDoorBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getMovmentBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getWindowBtn().setBackground(new java.awt.Color(51, 102, 0));

        } else {
            gui.getLightsBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getDoorBtn().setBackground(new java.awt.Color(102, 0, 0));
            gui.getMovmentBtn().setBackground(new java.awt.Color(102, 0, 0));
            gui.getWindowBtn().setBackground(new java.awt.Color(102, 0, 0));
        }

    }

    public void authorized(String pin) throws InterruptedException {
        if ("123456".equals(pin)) {
            gui.getAuthorized().setVisible(true);
            gui.getAuthorized().setText("Authorized Personnel");
            gui.getAuthorized().setForeground(new java.awt.Color(51, 102, 0));
            gui.getLightsBtn().setBackground(new java.awt.Color(102, 0, 0));
            gui.getDoorBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getMovmentBtn().setBackground(new java.awt.Color(51, 102, 0));
            gui.getWindowBtn().setBackground(new java.awt.Color(51, 102, 0));

        } else {
            gui.getAuthorized().setVisible(true);
            gui.getAuthorized().setText("Invalid Pin");
            gui.getAuthorized().setForeground(new java.awt.Color(102, 0, 0));
        }
    }

    public void voltageSignal() {
        powerVoltage.idle();
        gui.getMainPowerBar().setValue(powerVoltage.voltageValue);
    }

    public boolean isAlarmOn() {
        return state;
    }

    public boolean isState() {
        return state;
    }

    public doorSensor getDoorSensor() {
        return doorSensor;
    }

    public windowSensor getWindowSensor() {
        return windowSensor;
    }

    public movementSensor getMovementSensor() {
        return movementSensor;
    }

    public powerVoltage getPowerVoltage() {
        return powerVoltage;
    }

    public circuitMonitor getCircuitMonitor() {
        return circuitMonitor;
    }

    public AlarmGUI getGUI() {
        return gui;
    }

    public void setState(boolean state) throws InterruptedException {
        this.state = state;
        if (state == false) {
            this.PanicProtocol();
        } else if (state == true) {
            this.Clear();
        }

    }

}
