/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burglaralarmsystem;
   

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kemiaa
 */
public class circuitMonitor extends Thread {
    
     private final Alarm alarm;
    
        public circuitMonitor(Alarm alarm) {
        this.alarm = alarm;
    }
        
    @Override
    public void run() {
        while (true) {
            if (alarm.isAlarmOn()) {
                alarm.getPowerVoltage().idle();
            } 
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(circuitMonitor.class.getName()).log(Level.SEVERE, null, ex);
                 //Config.sendEvent(new circuitMonitor(alarm));
            }
        }
    }     
}
