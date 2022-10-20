/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;



/**
 *
 * @author Kemiaa
 */
public class DoorSensorReading {
       private final int doorReading;


    
    public DoorSensorReading(int doorReading) {
        this.doorReading = doorReading;
    }



    public int getDoorReading() {
        return doorReading;
    } 
}
