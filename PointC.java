/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matt1
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
  

}


