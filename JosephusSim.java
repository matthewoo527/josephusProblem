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
               add(file.nextLine());
            }
         }
         
         // make the ring circular by attaching last node's next to front
         track.next = circle;
         track = track.next;
         
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
      track.next = new PersonNode(val);
      track = track.next;
      size++;
   }
   
   public void eliminate() {
      // count to the elimination count
      for (int i = 0; i < eliminationCount - 1; i++) {
         track = track.next;
      }
      
      // print who will be eliminated
      System.out.println(track.next.name + " eliminated!");
      
      // eliminate the person and update "front" of the circle and size
      PersonNode newPoint = track.next.next;
      track.next = newPoint;
      size--;
   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      if (size == 1) {
         return true;
      }
      return false;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      StringBuilder output = new StringBuilder("");
      if (isOver()) {
         output.append(track.name + " is the last survivor!");
      } else {
         output.append("Remaining survivors: ");
         int i;
         for (i = 1; i <= size - 1; i++) {
            output.append(i + "-" + track.name + ", ");
            track = track.next;
         }
         output.append(i + "-" + track.name);
      }
      
      // print the remaining survivors (watch out for infinite loop since list is circular)
      

      return output.toString();
   }

}