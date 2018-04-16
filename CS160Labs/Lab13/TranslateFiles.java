// PrintWriter
import java.io.PrintWriter;

// Scanner
import java.util.Scanner;

// FileChooser
import fileChooser.*;

import java.util.*; 



public class TranslateFiles
{
  public static void main(String [] args)
  {
    Scanner scanner = FileChooser.openScanner();
    
    String content = scanner.useDelimiter("\\Z").next();
    //System.out.println(PigLatin.convertLine(content));
    //System.out.println(content);
    
    PrintWriter printwriter = FileChooser.openPrintWriter();
    printwriter.write(PigLatin.convertLine(content) + "");
    printwriter.close();
  } 
}