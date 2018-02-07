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
package driver.cmd;

import driver.Command;
import driver.JShell;

/**
 * man cmd: Prints out the documentation for the specified command.
 */
public class man extends Command {

  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   */
  public void execute(String[] args) {
    if (args.length == 1) {
      JShell.doc(args[0]);
    } else {
      System.out.println("Invalid command, please try again.");
    }
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[man cmd]\n"
        + "Prints out documentation for the specified\n" + "command.");
  }

}
