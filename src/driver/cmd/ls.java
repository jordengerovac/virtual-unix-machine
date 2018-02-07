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

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import driver.*;

/**
 * ls path1 path2...: Lists the contents of the directories specified. If no
 * directory is given, lists the contents of the current working directory. 
 * ls -r path1 path2 or ls -R path1 path2: Recursively list all subdirectories. 
 * If no path is given then recursively list all subdirectories of current working 
 * directory.
 * If path is a file the provide file name.  
 */
public class ls extends Command {
	private ArrayList<DefaultMutableTreeNode> globalChildList = 
		      new ArrayList<DefaultMutableTreeNode>();

  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   */
  public void execute(String[] args){
	  // If -r or -R provided.
	  if (args.length > 0 && (args[0].equals("-r") || args[0].equals("-R"))){
		  DefaultMutableTreeNode node;
		  if (args.length == 1){
			  node = JShell.os.getLocation();
			  recursiveDisplay(node);
		  } else {
			  for(int i =1; i <args.length; i++ ){
				  node = getNode(args[i]);
				  recursiveDisplay(node);
			  }
		  }
		// If -r or -R is not provided.
	  } else {
		  nonRecursiveDisplay(args);
	  }
  }
  
  /**
   * Runs the code when -r or -R is not present.
   * 
   * @param args Array of arguments.
   */
  public void nonRecursiveDisplay(String[] args){
	  DefaultMutableTreeNode node;
	    // if no path
	    if (args.length == 0) {
	      node = JShell.os.getLocation();
	      if (node.getChildCount() != 0) getChildren(node);
	      // print contents for each path
	    } else {
	      for (int i = 0; i < args.length; i++) {
	        node = getNode(args[i]);
	        System.out.println(buildPath(node)+ ":");
	        if (node.getUserObject() instanceof File) {
	        	System.out.println(((Item) node.getUserObject()).getName());
	        }
	        if (node.getChildCount() != 0) getChildren(node);
	      }
	    }
  }
  
  /**
   * Runs the code when -r or -R is present.
   * 
   * @param node Node whose content to display.
   */
  public void recursiveDisplay(DefaultMutableTreeNode node){
	  if(node.getUserObject() instanceof File){
		  System.out.println(((Item) node.getUserObject()).getName());
	  }
	  else{
		  //replace in below print statement if needed:((Item) node.getUserObject()).getName()
		  System.out.println(buildPath(node)+ ":");
		  getChildren(node);
		  
		  ArrayList<DefaultMutableTreeNode> recursiveChildList = globalChildList;
		  for(int i=0; i<recursiveChildList.size();i++){
			  DefaultMutableTreeNode currentChild = recursiveChildList.get(i);
			  if (currentChild.getUserObject() instanceof Directory){
				  recursiveDisplay(currentChild);
			  }
		  }
	  }
  }
	  

  /**
   * Prints out the names of the children of a given node.
   * 
   * @param node Node whose children to find.
   */
  private void getChildren(DefaultMutableTreeNode node) {
	ArrayList<DefaultMutableTreeNode> childList = new ArrayList<DefaultMutableTreeNode>();
    int numberOfChildren = node.getChildCount();
    if (numberOfChildren > 0) {
      // does not do anything if no children
      // iterates through the children of node
      for (int i = 0; i < numberOfChildren; i++) {
        DefaultMutableTreeNode child =
            (DefaultMutableTreeNode) node.getChildAt(i);
        childList.add(child);
        String name = ((Item) child.getUserObject()).getName();
        System.out.print(name + " ");
      }
      System.out.print("\n");
    }
    globalChildList = childList;
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[ls]\n"
        + "Lists the contents of the current working directory.\n"
        + "[ls -r] or [ls -R]\n"
        + "Recursively list all subdirectories of current working directory.\n"
        + "[ls path1 path2 ...]\n"
        + "If path is a directory then list its contents.\n"
        + "[ls -R path1 path2 ...] or [ls -r path1 path2 ...]\n"
        + "If path is a directory then recursively list all subdirectories.\n"
        + "In any call, if path is a file then provide its name."); 	
  }
}
