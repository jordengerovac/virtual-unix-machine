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
package test.cmd;

import driver.Command;

/**
 * echo string >/>> outfile: > creates outfile containing string, overwriting if
 * it already exists. >> does the same thing, but appends rather than
 * overwrites. If no outfile is specified, prints string.
 */
public class echo extends Command {

  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   */
  public void execute(String[] args) throws Exception {
    if (args.length == 1) {
      System.out.println(args[0].substring(1, args[0].length() -1));
    } else if (args.length > 1) {
      String line = "";
      for (int i = 0; i < args.length; i++) {
        // is first
        if (i == 0) {
          line = args[i].substring(1);
        // is last
        } else if (i == args.length - 1) {
          line = line + " " + args[i].substring(0, args[i].length()-1);
        // is between
        } else {
          line = line + " " + args[i];
        }
      }
      System.out.println(line);
    } else {
      System.out.println("Invalid command, please try again.");
    }
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[echo string]\n" + "Prints string.");
  }

}
