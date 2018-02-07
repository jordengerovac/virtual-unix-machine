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
package driver;

import java.util.Arrays;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Superclass of all executable commands. Contains helper methods that handle
 * paths and the getting of nodes.
 */
public class Command {

  /**
   * Returns an array of directories in order.
   * 
   * @param path Raw string path input.
   * @return Array containing strings that correspond to objects in the path.
   */
  protected String[] pathToArray(String path) {
    while (path.contains("//")) {
      path = path.replace("//", "/");
    }
    return path.split("/");
  }

  /**
   * Converts an array of strings into a path.
   * 
   * @param array Array of objects.
   * @return String path based on the ordered array.
   */
  protected String arrayToPath(String[] array) {
    String path = "";
    for (int i = 0; i < array.length; i++) {
      path = path + "/" + array[i];
    }
    return path;
  }

  /**
   * Returns parent of file or directory to be made.
   * 
   * @param path Raw string path input.
   * @return Node at given path.
   */
  protected DefaultMutableTreeNode getParentNode(String path) {
    String[] pathArray = pathToArray(getWholePath(path));
    pathArray = Arrays.copyOfRange(pathArray, 0, pathArray.length - 1);
    path = arrayToPath(pathArray);
    return getNode(path);
  }

  /**
   * Returns the whole path from root as a string from a specified path.
   * 
   * @param path Raw string path.
   * @return Complete string path from the root.
   */
  protected String getWholePath(String path) {
    while (path.contains("//")) {
      path = path.replace("//", "/");
    }
    if (path.equals("/")) {
      return path;
    } else if (!path.substring(0, 1).equals("/")) {
      if (JShell.os.getLocation() == JShell.os.getRoot()) {
        path = "/" + path;
      } else {
        path = buildPath(JShell.os.getLocation()) + "/" + path;
      }
    }
    // removes trailing / if exists
    if (path.substring(path.length() - 1).equals("/")) {
      path = path.substring(0, path.length() - 1);
    }
    while (path.contains("//")) {
      path = path.replace("//", "/");
    }
    return path;
  }

  /**
   * Returns the specified node if a path exists, otherwise return null.
   * 
   * @param path Raw string path.
   * @return Node at given path.
   */
  protected DefaultMutableTreeNode getNode(String path) {
    path = getWholePath(path);
    if (path.equals("/")) {
      return JShell.os.getRoot();
    }
    String[] pathArray = pathToArray(path.substring(1));
    DefaultMutableTreeNode node = JShell.os.getRoot();
    for (int i = 0; i < pathArray.length; i++) {
      if (pathArray[i].equals("..")) {
        node = (DefaultMutableTreeNode) node.getParent();
        continue;
      } else if (pathArray[i].equals(".")) {
        continue;
      } else {
        // if not .. or ., start checking for matches
        boolean check = false;
        for (int j = 0; j < node.getChildCount(); j++) {
          DefaultMutableTreeNode child =
              (DefaultMutableTreeNode) node.getChildAt(j);         
          String name = ((Item) child.getUserObject()).getName();
          if (name.equals(pathArray[i])) {
            node = (DefaultMutableTreeNode) node.getChildAt(j);
            check = true;
          }
        }
        if (check == false) {
          return null;
        }
      }
    }
    return node;
  }

  /**
   * Check if a child with name exists at the specified node.
   * 
   * @param node Node whose children to check.
   * @param name Name of child to check for.
   * @return True if a child with name exists, false if not.
   */
  protected boolean childExists(DefaultMutableTreeNode node, String name) {
    for (int j = 0; j < node.getChildCount(); j++) {
      DefaultMutableTreeNode child =
          (DefaultMutableTreeNode) node.getChildAt(j);
      String childName = "";
      if (child.getUserObject() instanceof Directory) {
        childName = ((Directory) child.getUserObject()).getName();
      } else if (child.getUserObject() instanceof File) {
        childName = ((File) child.getUserObject()).getName();
      }
      if (childName.equals(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the string path of a node.
   * 
   * @param node Node whose path is to be retrieved.
   * @return String path of the node.
   */
  protected String buildPath(DefaultMutableTreeNode node) {
    TreeNode[] nodes = node.getPath();
    // if the node is root, return /
    if (node == JShell.os.getRoot()) return "/";
    // otherwise build the path and remove starting slash
    String path = "";
    for (int i = 0; i < nodes.length; i++) {
      node = (DefaultMutableTreeNode) nodes[i];
      Item obj = (Item) node.getUserObject();
      path = path + "/" + obj.getName();
    }
    return path.substring(1);
  }

}
