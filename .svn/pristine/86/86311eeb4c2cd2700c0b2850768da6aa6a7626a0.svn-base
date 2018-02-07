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

import java.util.Stack;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Store the directory/file structure for the program.
 */
public class OperatingSystem {

  // stack for pushd/popd commands
  public Stack<Object> directoryStack = new Stack<Object>();
  // current working directory
  public static DefaultMutableTreeNode cwd;
  // initializing root directory
  Item rootDir = new Directory("");
  DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootDir);

  /**
   * Constructor, setting current working directory to root at start.
   */
  public OperatingSystem() {
    cwd = root;
  }

  /**
   * Sets current working directory.
   * 
   * @param dir The directory to set the current working directory to.
   */
  public void setLocation(DefaultMutableTreeNode dir) {
    cwd = dir;
  }

  /**
   * Getter for the current working directory.
   * 
   * @return The Current working directory node.
   */
  public DefaultMutableTreeNode getLocation() {
    return cwd;
  }

  /**
   * Getter for the root node.
   * 
   * @return The Root node.
   */
  public DefaultMutableTreeNode getRoot() {
    return root;
  }

}
