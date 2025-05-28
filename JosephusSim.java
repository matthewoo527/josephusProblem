import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode circle;     // a PersonNode pointer that tracks first node
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       
   private PersonNode track;      // a PersonNode pointer to help with elimination

   public JosephusSim(String fileName) {
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         size = 0;
         if (file.hasNextLine()) {
            String firstName = file.nextLine();
            circle = new PersonNode(firstName);
            track = circle;
            size++;
            while (file.hasNextLine()) {
               String name = file.nextLine();
               track.next = new PersonNode(name);
               track = track.next;
               size++;
            }
         }
         
         // make the ring circular by attaching last node's next to front
         track.next = circle;
         
         // remember the last node as the one in front of the next to get eliminated
         
         // generate, print, and save the random elimination count
         Random rand = new Random();
         eliminationCount = rand.nextInt();

      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
      track.next = circle;
   }
   
   public void eliminate() {
      // count to the elimination count
      eliminationCount++;
      
      // print who will be eliminated
      System.out.printf();
      
      // eliminate the person and update "front" of the circle and size
      

   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      if (track.next == null) {
         return true;
      }
      return false;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      if (isOver()) {
         System.out.printf("%s is the last survivor!", track.name);
      } else {
         System.out.printf("Remaining survivors: ");
         for (int i = 0; i < size - 1; i++) {
            System.out.printf("%d-%s, ", i, track.name);
            track = track.next;
         }
         System.out.printf("%d-%s", i, track.name);
      }
      
      // print the remaining survivors (watch out for infinite loop since list is circular)
      

      return "";
   }

}