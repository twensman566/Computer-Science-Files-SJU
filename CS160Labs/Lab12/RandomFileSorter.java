import acm.program.DialogProgram;

public class RandomFileSorter extends DialogProgram
{
 public void run()
   
 {
  double [] doubleArray = DoubleUtilities.readFile();
  DoubleUtilities.sort(doubleArray);
  DoubleUtilities.writeFile(doubleArray);

 }
}
