/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author matt1
 * @author John L. Carveth
 */
public class PointC implements PointCP {
    
    
    private double x;
    private double y;
    
    public PointC(double x, double y) {
        this.x = x;
        this.y = y;
    
    }   
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRho() {
    
    return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));  
    }
    
    public double getTheta() {
    
    return Math.toDegrees(Math.atan2(y, x));
    
    }
    public double getDistance(PointCP pointC)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointC.getX();
        double deltaY = getY() - pointC.getY();
        
        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public PointC rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        
        return new PointC(
        (Math.cos(radRotation) * x) - (Math.sin(radRotation) * y),
        (Math.sin(radRotation) * x) + (Math.cos(radRotation) * y));
    }

  /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString() {
        return "Stored as Cartesian [" + getX() + "," + getY() + "]";
    }
}