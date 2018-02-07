package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.JShell;

public class cpTest {
  private final ByteArrayOutputStream output = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(output));
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
  }

  @Test
  /**
   * Tests various argument cases.
   */
  public void testExecute() throws Exception {
    String[] args;
    // make two dirs at root and a dir in a
    args = new String[] {"a", "b", "a/c"};
    JShell.execute("mkdir", args);
    // copy c into b
    args = new String[] {"a/c", "/b"};
    JShell.execute("cp", args);
    // change dir to b
    args = new String[] {"/b"};
    JShell.execute("cd", args);
    // list dirs in b
    args = new String[] {};
    JShell.execute("ls", args);
    assertEquals(output.toString(), "c \n");
    // change dir to a
    args = new String[] {"/a"};
    JShell.execute("cd", args);
    // list dirs in a
    args = new String[] {};
    JShell.execute("ls", args);
    assertEquals(output.toString(), "c \n" + "c \n");
  }

}
