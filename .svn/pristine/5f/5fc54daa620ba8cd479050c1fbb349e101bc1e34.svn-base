package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.JShell;

public class numberTest {
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
    // make one dir
    args = new String[] {"a"};
    JShell.execute("mkdir", args);
    JShell.history.write("mkdir a");
    // make another dir
    args = new String[] {"b"};
    JShell.execute("mkdir", args);
    JShell.history.write("mkdir b"
        + "");
    // recall the first command
    args = new String[] {"1"};
    JShell.execute("number", args);
    assertEquals(output.toString(), "a already exists."+s);
  }

}
