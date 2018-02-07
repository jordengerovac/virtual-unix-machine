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

import driver.Command;
import driver.Directory;
import driver.File;
import driver.Item;

/**
 * mv oldpath newpath: Moves item from oldpath to newpath. 
 */
public class mv extends Command {

  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   */
  public void execute(String[] args) {
    if (args.length == 2) {
      DefaultMutableTreeNode oldNode = getNode(args[0]);
      DefaultMutableTreeNode newNode = getNode(args[1]);
      // if moving to a directory
      if (oldNode == null) {
        System.out.println("Item does not exist.");
      } else if (oldNode != null && newNode.getUserObject() instanceof Directory) {
        // check if an item with that name already exists
        // removes existing item
        String oldName = ((Item) oldNode.getUserObject()).getName();       
        for (int i = 0; i < newNode.getChildCount(); i++) {
          DefaultMutableTreeNode child = 
              (DefaultMutableTreeNode) newNode.getChildAt(i);
          String newName = ((Item) child.getUserObject()).getName();
          if (oldName.equals(newName)) newNode.remove(child);
        }
        newNode.add(oldNode);       
      // if file moving to a file
      } else if (oldNode.getUserObject() instanceof File) {
        DefaultMutableTreeNode parentNode = getParentNode(args[1]);
        // replaces if exists, otherwise just adds
        if (newNode != null) {
          parentNode.remove(newNode);
        }
        parentNode.add(oldNode);
      // directory moving to a file
      } else System.out.println("Cannot move a directory to a file.");
    } else System.out.println("Invalid command, please try again.");
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[mv cmd]\n"
        + "Moves item from oldpath to newpath.");
  }

}
