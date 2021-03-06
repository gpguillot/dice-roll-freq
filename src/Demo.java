import java.util.ArrayList;

/*
 * This class contains the main entry point and runs the program. 
 */
public class Demo 
{
   private int numDieToRoll;   

   public static void main(String[] args) 
   {
      Demo demo = new Demo(5);
      demo.run();
   }
   
   /*
    * Constructor for demo with param specifying number of die to roll. 
    * 
    * @param n the number of die to roll
    */
   public Demo(int n)
   {
      this.numDieToRoll = n;
   }
   
   /*
    * Runs the demo. 
    */
   public void run()
   {
      Cup cup = new Cup(this.numDieToRoll);
      System.out.println("Tossing cup of " + this.numDieToRoll + " die...");
      cup.toss();
      System.out.print("Ok, the face values are: ");
      cup.printResults();
      
      
      System.out.println("\nNow, Let's tally up the frequency table...");
      Counter counter = new Counter();
      ArrayList<Integer> results = counter.extractFaceValues(cup.getDice());
      
      System.out.println("Aaaaand here it is...");
      int numOfFaces = cup.getDice().get(0).getNUMFACES();
      int[] r = counter.countAllFrequencies(results, numOfFaces);
      
      System.out.println("-----------");
      System.out.println("Face" + " | " + "Freq");
      System.out.println("-----------");
      
      for (int i = 0; i < numOfFaces; i++)
      {
         System.out.println("   " + (i + 1) + " | " + r[i]);
      }

   }
 
}

