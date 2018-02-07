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

import java.util.ArrayList;

/**
 * File object. Stores its name and its contents.
 */
public class File implements Item {

  private String name;
  private ArrayList<String> contents = new ArrayList<String>();

  /**
   * Constructor for files.
   * 
   * @param name Name of this file.
   */
  public File(String name) {
    this.name = name;
  }

  /**
   * Getter for the name of this file.
   * 
   * @return The name of this file.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Write a line to the contents of this file.
   * 
   * @param line The line to be written.
   */
  public void write(String line) {
    this.contents.add(line);
  }

  /**
   * Prints contents of this file.
   */
  public void readAll() {
    for (int i = 0; i < contents.size(); i++) {
      System.out.println(contents.get(i));
    }
  }

  /**
   * Getter for all the lines in this file. 
   * 
   * @return The lines contained in this file.
   */
  public ArrayList<String> readEachLine(){
	  return this.contents;
  }
  
  /**
   * Clears contents of this file.
   */
  public void clear() {
    contents.clear();
  }

}
