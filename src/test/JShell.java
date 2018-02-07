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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.reflect.*;

/**
 * Launches all other classes in the package. Takes user input.
 */
public class JShell {

  // initialization
  public static OperatingSystem os = new OperatingSystem();
  public static History history = new History();
  public static HashMap<String, String> map = setMap();
  private static Scanner sc;

  public static void main(String[] args) {
    
    sc = new Scanner(System.in);
    while (true) {
      System.out.print("/# ");
      String input = sc.nextLine().trim();
      if (input.length() > 0) {
        if (input.charAt(0)=='!') {
          String[] argList = new String[1];
          argList[0] = String.valueOf(input.substring(1));
          execute("number", argList);
        } else {
          history.write(input);
          String[] inputList = input.split("\\s+");
          // TODO: check for redirection
          int len = inputList.length;
          if (len > 2 && (inputList[len - 2].equals(">") 
              || inputList[len - 2].equals(">>"))) {
            execute("redirect", inputList);
          // if not redirection, execute normally
          } else {
          String cmd = inputList[0];
          String[] argList = Arrays.copyOfRange(inputList, 1, inputList.length);
          // run the command
          execute(cmd, argList);
          }
        }
      }
    }
  }

  /**
   * Run a command using its name and a list of following args.
   * 
   * @param cmd The command to run.
   * @param args The arguments to pass.
   */
  public static void execute(String cmd, String[] args) {
    try {
      @SuppressWarnings("unchecked")
      Class<Command> cmdClass = (Class<Command>) Class.forName(map.get(cmd));
      Object cmdObject = cmdClass.newInstance();
      Method run = cmdClass.getMethod("execute", new Class[] {String[].class});
      run.invoke(cmdObject, new Object[] {args});
    } catch (Exception e) {
      System.out.println("Invalid command, please try again.");
    }
  }

  /**
   * Calls documentation for a command.
   * 
   * @param cmd The command to call.
   */
  public static void doc(String cmd) {
    try {
      @SuppressWarnings("unchecked")
      Class<Command> cmdClass = (Class<Command>) Class.forName(map.get(cmd));
      Object cmdObject = cmdClass.newInstance();
      Method run = cmdClass.getMethod("doc");
      run.invoke(cmdObject, new Object[] {});
    } catch (Exception e) {
      System.out.println("Documentation for specified command not found.");
    }
  }
  
  /**
   * Sets the map of commands.
   */
  public static HashMap<String, String> setMap() {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("cat", "driver.cmd.cat");
    map.put("cat2", "driver.cmd.cat2");
    map.put("cd", "driver.cmd.cd");
    map.put("cp", "driver.cmd.cp");
    map.put("cp2", "driver.cmd.cp2");
    map.put("echo", "driver.cmd.echo");
    map.put("exit", "driver.cmd.exit");
    map.put("get", "driver.cmd.get");
    map.put("history", "driver.cmd.history");
    map.put("ls", "driver.cmd.ls");
    map.put("man", "driver.cmd.man");
    map.put("mkdir", "driver.cmd.mkdir");
    map.put("mv", "driver.cmd.mv");
    map.put("number", "driver.cmd.number");    
    map.put("popd", "driver.cmd.popd");
    map.put("pushd", "driver.cmd.pushd");
    map.put("pwd", "driver.cmd.pwd");
    map.put("redirect", "driver.cmd.redirect");
    map.put("grep", "driver.cmd.grep");

    return map;
  }
}
