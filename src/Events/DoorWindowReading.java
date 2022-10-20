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
public class DoorWindowReading {
    
    private final int doorReading;


    
    public DoorWindowReading(int doorReading) {
        this.doorReading = doorReading;
    }

    public DoorWindowReading() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getDoorReading() {
        return doorReading;
    }
}
