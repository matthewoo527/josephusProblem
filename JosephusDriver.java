import java.util.*;

public class JosephusDriver {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      JosephusSim simulation = new JosephusSim("people.txt");
      
      while(!simulation.isOver()) {
         System.out.println(simulation);
         System.out.println("\nContinue elimination? <press enter>");
         console.nextLine(); // make the user hit enter to continue
         simulation.eliminate();
      }
      
      System.out.println(simulation);
   }
}

/*
 Remaining survivors: 1-Muhammad, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal, 6-River, 7-Soham, 8-Leon, 9-Will, 10-Qiao
 
 Continue elimination? <press enter>
 
 Muhammad eliminated!
 Remaining survivors: 1-Qiao, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal, 6-River, 7-Soham, 8-Leon, 9-Will
 
 Continue elimination? <press enter>
 
 Qiao eliminated!
 Remaining survivors: 1-Will, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal, 6-River, 7-Soham, 8-Leon
 
 Continue elimination? <press enter>
 
 Will eliminated!
 Remaining survivors: 1-Leon, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal, 6-River, 7-Soham
 
 Continue elimination? <press enter>
 
 Leon eliminated!
 Remaining survivors: 1-Soham, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal, 6-River
 
 Continue elimination? <press enter>
 
 Soham eliminated!
 Remaining survivors: 1-River, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal
 
 Continue elimination? <press enter>
 
 River eliminated!
 Remaining survivors: 1-Krystal, 2-Beza, 3-Ibrar, 4-Nur
 
 Continue elimination? <press enter>
 
 Krystal eliminated!
 Remaining survivors: 1-Nur, 2-Beza, 3-Ibrar
 
 Continue elimination? <press enter>
 
 Nur eliminated!
 Remaining survivors: 1-Ibrar, 2-Beza
 
 Continue elimination? <press enter>
 
 Ibrar eliminated!
 Beza is the last survivor!
 
*/
