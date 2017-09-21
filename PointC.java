/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matt1
 */
public class PointC {
    
    
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
public PointC rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointC(
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }
}


