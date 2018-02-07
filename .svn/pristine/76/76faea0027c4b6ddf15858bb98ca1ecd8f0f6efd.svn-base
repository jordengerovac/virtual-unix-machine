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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import javax.swing.tree.DefaultMutableTreeNode;

import driver.Command;
import driver.File;
import driver.Item;
import driver.JShell;

/**
 * echo string >/>> outfile: > creates outfile containing string, overwriting if
 * it already exists. >> does the same thing, but appends rather than
 * overwrites. If no outfile is specified, prints string.
 */
public class redirect extends Command {
  
  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private PrintStream previous;
  
  /**
   * Runs the code unique to this command.
   * 
   * @param args Array of arguments to be passed by JShell.
   */
  public void execute(String[] args) throws Exception {
    previous = System.out;
    String cmd = args[0]; 
    String path = args[args.length - 1];    
    System.setOut(new PrintStream(output));
    
    JShell.execute(cmd, Arrays.copyOfRange(args, 1, args.length - 2));
    if (!output.toString().equals("")) {
      DefaultMutableTreeNode node = getNode(path);
      // create new file if it does not exist
      if (node == null) {
        String[] pathArray = pathToArray(getWholePath(path));
        String fileName = pathArray[pathArray.length - 1];
        Item newFile = new File(fileName);
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
        DefaultMutableTreeNode parent = getParentNode(path);
        if (parent.getUserObject() instanceof File) {
          throw new Exception();
        }
        parent.add(newNode);
        node = newNode;
      }
      if (node.getUserObject() instanceof File) {
        File file = (File) node.getUserObject();
        if (args[args.length - 2].equals(">")) {
          file.clear();    
          file.write(output.toString());
        } else if (args[args.length - 2].equals(">>")) {
          file.write(output.toString());
        }
      } else {
        System.out.println("Path specified is a directory.");    
      } 
    }
    System.setOut(previous);
  }

  /**
   * Prints documentation for this command.
   */
  public void doc() {
    System.out.println("[echo string]\n" + "Prints string.\n"
        + "[echo string > file]\n"
        + "Creates file containing string, and overwrites it\n"
        + "if it already exists.\n" + "[echo string >> file]\n"
        + "Appends string to file.");
  }

}
