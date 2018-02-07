// **********************************************************
// Assignment2:
// Student1: Jorden Gerovac
// UTOR user_name: gerovac1
// UT Student #: 1001230919
// Author: Jorden Gerovac
//
// Student2: Justin Mao
// UTOR user_name: maojusti
// UT Student #: 1001756922
// Author: Justin Mao
//
// Student3: Aditya Dhankar
// UTOR user_name: dhankara
// UT Student #: 999857436
// Author: Aditya Dhankar
//
// Student4: Manpreet Nanreh
// UTOR user_name: nanrehma
// UT Student #: 999865999
// Author: Manpreet Nanreh
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************
package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * History object. Keeps track of input lines and can print them.
 */
public class History {

  private ArrayList<String> history = new ArrayList<String>();

  /**
   * Adds line to memory.
   * 
   * @param line The line to be added.
   */
  public void write(String line) {
    history.add(line);
  }

  /**
   * Prints out num lines of history starting from the most recent.
   * 
   * @param num The number of lines to print.
   */
  public void read(int num) {
    // iterates backwards through history until reaching num entries
    if (num <= history.size()) {
      for (int i = history.size() - 1; i >= history.size() - num; i--) {
        System.out.println(i + 1 + " " + history.get(i));
      }
    } else {
      System.out.println("Exceeded number of commands stored.");
    }
  }

  /**
   * Print out all lines of history starting from the most recent.
   */
  public void readAll() {
    // iterates backwards through history
    for (int i = history.size() - 1; i >= 0; i--) {
      System.out.println(i + 1 + " " + history.get(i));
    }
  }
  
//  public void recall(int num){
//    int temp = 0;
//    for (int i = history.size() - 1; i >= 0; i--) {
//      if ((i+1)==num){
//        System.out.println(history.get(i));
//        temp = i;
//      }
//    }
//        String[] inputList = history.get(temp).split("\\s+");
//        String[] argList = Arrays.copyOfRange(inputList, 1, inputList.length);
//        JShell.execute(inputList[0], argList);
//  }
  
  // @jorden: wouldn't this work with less runtime or am I missing something
  public void recall(int num) {
    if (num <= this.history.size()) {
      String line = this.history.get(num - 1);
      // write line retrieved to history
      JShell.history.write(line);
      // run command retrieved
      String[] inputList = line.split("\\s+");
      String[] argList = Arrays.copyOfRange(inputList, 1, inputList.length);
      JShell.execute(inputList[0], argList);
    } else {
      System.out.println("No line to retrieve at position specified.");
    }
  }
  
  
}


