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
public class MovementSensorReading {

    private final int movementReading;


    
    public MovementSensorReading(int movementReading) {
        this.movementReading = movementReading;
    }

    public MovementSensorReading() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getMovementReading() {
        return movementReading;
    }
    
}
