// Program
import acm.program.Program;


/**
 * A program that displays a table of a cannon ball's travel from firing until
 * it hits the ground for a specified initial velocity and angle.
 *
 * @author <your names here> based on a template by CSB|SJU Computer Science
 *         faculty members
 */
public class Cannon extends Program
{
  // acceleration due to gravity at sea level on earth
  private static final double GRAVITY = -9.80665;
  
  
  /**
   * Runs the cannon simulation
   */
  public void run()
  {
    double v0 = this.readDouble("Enter the intial velocity of the cannon ball:  ");
    double A = this.readDouble("Enter the intial Angle of the cannon in degrees in between 0 and 90:  ");
    
    for(double t = 0; t<=20; t++)
    {
      double time = (t*timeToHit(v0,A))/20.0;
      double h = this.height(v0,A,time);
      double d = this.dist(v0,A,time);
      this.println(String.format("%7.3f   %7.3f   %7.3f", time, h, d));
    }
  }
  
  
  /**
   * Computes the height of a cannon ball shot from the ground at initial
   * velocity v0, angle A at t seconds after the shot
   *
   * @param v0 the initial velocity in units/second (could be any unit of
   *           length)
   * @param A  the firing angle in degrees
   * @param t  the elapsed time since firing in seconds
   *
   * @return   the computed value of the height
   */
  public double height(double v0, double A, double t)
  {
    //***code to compute the value here***
    double vVert = v0 * Math.sin(Math.toRadians(A)); 
    double height = ((vVert*t)+(GRAVITY*(Math.pow(t,2)/2)));
    
    return height /***replace zero with the computed value***/;
  }
  
  
  /**
   * Computes the distance of a cannon ball shot from the ground at initial
   * velocity v0, angle A at t seconds after the shot
   *
   * @param v0 the initial velocity in units/second (could be any unit of
   *           length)
   * @param A  the firing angle in degrees
   * @param t  the elapsed time since firing in seconds
   *
   * @return   the computed value of the distance
   */
  public double dist( double v0, double A, double t)
  {
    
    double vHori = v0 * Math.cos(Math.toRadians(A));
    
    double dist = (vHori * t);
    return dist;
  }
  
  
  /**
   * Computer the amount of time the cannon ball was in the air until it hits the ground.
   * 
   * @param v0 the initial velocity in units/second (could be any unit of
   *           length)
   * 
   *@param A the firing angle in degrees (must be in radians)
   * 
   *@return the computed amount of time
   */
  
  public double timeToHit( double v0, double A)
  {
   double t = (-2.0*v0*Math.sin(Math.toRadians(A)))/(GRAVITY);
   return t;
  }
  
  public double distanceToHit(double v0, double A)
  {
    double time = this.timeToHit(v0 , A);
    double distance = this.dist(v0, A, time);
    return distance;
  }
                  
  
  //***Put the remaining three specified functions here using height as a model
  //***Be sure to include proper Javadoc comments like the one above
}
