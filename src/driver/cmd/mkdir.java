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

import javax.swing.tree.DefaultMutableTreeNode;

import driver.*;

/**
 * mkdir dir1 dir2...: Create a new directory at each path specified.
 */
public class mkdir extends Command {

  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   */
  public void execute(String[] args) throws Exception {
    // if has arguments
    if (args.length >= 1) {
      for (int i = 0; i < args.length; i++) {
        String path = args[i];
        String[] pathArray = pathToArray(getWholePath(path));
        String name = pathArray[pathArray.length - 1];
        Item newDir = new Directory(name);
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newDir);
        DefaultMutableTreeNode parent = getParentNode(path);
        // create ONLY if an object with that name does not exist
        if (parent.getUserObject() instanceof File) {
          throw new Exception();
        }
        if (!childExists(parent, name)) {
          parent.add(newNode);
        } else {
          System.out.println(name + " already exists.");
        }
      }
    } else {
      System.out.println("Invalid command, please try again.");
    }
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[mkdir dir1 dir2...]\n"
        + "Create a new directory at each path specified.");
  }

}
