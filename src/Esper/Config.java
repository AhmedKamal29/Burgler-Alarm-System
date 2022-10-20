/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;

import Events.AuthorizationEvent;
import Events.ClearEvent;
import Events.DoorSensorReading;
import Events.MovementSensorReading;
import Events.PanicEvent;
import Events.powerVoltageReading;
import Events.windowSensorReading;
import burglaralarmsystem.Alarm;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 *
 * @author Kemiaa
 */

public class Config {

    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {
        engine.getEPAdministrator().getConfiguration().addEventType(MovementSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(windowSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(DoorSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(powerVoltageReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(Alarm.class);
        engine.getEPAdministrator().getConfiguration().addEventType(PanicEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ClearEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(AuthorizationEvent.class);

        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }

    public static void sendEvent(Object o) {
        engine.getEPRuntime().sendEvent(o);
    }
}
