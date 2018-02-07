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

import javax.swing.tree.DefaultMutableTreeNode;

import driver.Command;
import driver.File;

/**
 * cat file: Prints the contents of the specified files.
 */
public class cat extends Command {

  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   */
  public void execute(String[] args) {
    if (args.length == 1) {
      File file = (File) getNode(args[0]).getUserObject();
      file.readAll();
    } else if (args.length > 1) {
      for (int i = 0; i < args.length; i++) {
        DefaultMutableTreeNode node = getNode(args[i]);
        if (node == null) System.out.println(args[i] + " does not exist.");
        else if (node.getUserObject() instanceof File) {
          File file = (File) getNode(args[i]).getUserObject();
          System.out.println(args[i] + ":");
          file.readAll();
        } else System.out.println(args[i] + " is not a file.");  
      }
//    } else if (args.length > 1){
//      ArrayList<String> notFile = new ArrayList<String>();
//      DefaultMutableTreeNode currentFile;
//      
//      for(int i=0; i <args.length; i++){
//          currentFile = getNode(args[i]);
//          if (currentFile != null && (currentFile.getUserObject() instanceof File)){
//              ((File) currentFile.getUserObject()).readAll();
//          }
//          else{
//              notFile.add(args[i]);
//          }
//      }
//      
//      for(int a=0; a<notFile.size();a++){
//          System.out.println(notFile.get(a)+" is not a File.");
//      }
    } else System.out.println("Invalid command, please try again.");
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[cat file]\n"
        + "Prints the contents of the specified files.");
  }

}
