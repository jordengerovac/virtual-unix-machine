package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.JShell;

public class mvTest {
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
    String s = System.getProperty("line.separator");
    String[] args;
    // make two dirs at root
    args = new String[] {"a", "b"};
    JShell.execute("mkdir", args);
    // move a into b
    args = new String[] {"a", "b"};
    JShell.execute("mv", args);
    // change dir to b
    args = new String[] {"b"};
    JShell.execute("cd", args);
    // list dirs in b
    args = new String[] {};
    JShell.execute("ls", args);
    assertEquals(output.toString(), "a \n");

  }

}
