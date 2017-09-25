// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
import java.util.Random;

public class PointCPD1 {
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private char typeCoord;
  
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double xOrRho;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double yOrTheta;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCPD1(char type, double xOrRho, double yOrTheta) {
    if(type != 'C' && type != 'P')
      throw new IllegalArgumentException();
    this.xOrRho = xOrRho;
    this.yOrTheta = yOrTheta;
    typeCoord = type;
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX() {
    if(typeCoord == 'C') 
      return xOrRho;
    else 
      return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
  }
  
  public double getY() {
    if(typeCoord == 'C') 
      return yOrTheta;
    else 
      return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
  }
  
  public double getRho() {
    if(typeCoord == 'P') 
      return xOrRho;
    else 
      return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
  }
  
  public double getTheta() {
    if(typeCoord == 'P')
      return yOrTheta;
    else 
      return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
  }
  
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar() {
    if(typeCoord != 'P')
    {
      //Calculate RHO and THETA
      double temp = getRho();
      yOrTheta = getTheta();
      xOrRho = temp;
      
      typeCoord = 'P';  //Change coord type identifier
    }
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian() {
    if(typeCoord != 'C')
    {
      //Calculate X and Y
      double temp = getX();
      yOrTheta = getY();
      xOrRho = temp;
   
      typeCoord = 'C';	//Change coord type identifier
    }
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP pointB) {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCPD1 rotatePoint(double rotation) {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCPD1('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
    public String toString() {
        return "Stored as " + (typeCoord == 'C' 
        ? "Cartesian  (" + getX() + "," + getY() + ")"
        : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
    }

}

class D1D5Test {

    private static void computeD1(int n) {
        for (int i=0; i < n; i++) {

            Random r = new Random();
            int r1 = r.nextInt(101);
            int r2 = r.nextInt(101);

            PointCPD1 p1 = new PointCPD1('C', r1, r2);
            PointCPD1 p2 = new PointCPD1('P', r2, r1);

            int theta = r.nextInt(181);
            p1.rotatePoint(theta);
            p2.rotatePoint(theta);

            p1.getRho();
            p1.getTheta();
            p1.getX();
            p1.getY();

            p2.getX();
            p2.getY();
            p2.getRho();
            p2.getTheta();
        }
    }

    private static void computeD5(int n) {
      for (int i=0; i < n; i++) {
          Random r = new Random();
          int r1 = r.nextInt(101);
          int r2 = r.nextInt(101);
          PointCP p1 = new PointC(r1, r2);
          PointCP p2 = new PointP(r2, r1);

          p1.getRho();
          p1.getTheta();
          p1.getX();
          p1.getY();

          int theta = r.nextInt(181);
          p1.rotatePoint(theta);
          p2.rotatePoint(theta);

          p2.getX();
          p2.getY();
          p2.getRho();
          p2.getTheta();
      }
  }
    /**
     * Test Eff. of D1 vs D5 (PointCP)
     * @param args[0] the size of the test to do > 1
     */
    public static void main(String[] args) {
        // 1. Efficiency when creating instances.
        long start = System.nanoTime();
        computeD1(500000000);
        long end = System.nanoTime();

        long time = (end - start) / 1000000000;
        System.out.println("Creating Instances (D1): " + String.valueOf(time) + "s.");

        start = System.nanoTime();
        computeD5(500000000);
        end = System.nanoTime();

        time = (end - start) / 1000000000;
        System.out.println("Creating Instances (D5): " + String.valueOf(time) + "s.");
    }
}
