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

import java.net.URL;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;

import driver.*;

/**
 * get url: retrieves the file at url and adds it to the
 * current working directory
 */
public class get extends Command {

  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   * @throws Exception malformed url or such
   */
  public void execute(String[] args) throws Exception {
    if (args.length == 1) {
      // get name of file
      String[] fileArray = pathToArray(args[0]);
      String name = fileArray[fileArray.length - 1];
      // TODO: check if file already exists
      // otherwise: create file and add lines to it
      File newFile = new File(name);
      // get lines
      URL url = new URL(args[0]);
      Scanner s = new Scanner(url.openStream());
      while (s.hasNextLine()) {
        String line = s.nextLine();
        // add line to file
        newFile.write(line);
      }
      s.close();
      // add newly created file to a node in the cwd
      DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
      JShell.os.getLocation().add(newNode);
      
    }
    
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[get url]\n"
        + "Retrieves the file at url and adds it to the\n"
        + "current working directory.");
  }

}
