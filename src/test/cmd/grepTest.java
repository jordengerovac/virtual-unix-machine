package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.JShell;

public class grepTest {
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
    // create file in root
    args = new String[] {"hi", ">", "file1.txt"};
    JShell.execute("echo", args);
    // look for string in file
    args = new String[] {"h", "file1.txt"};
    JShell.execute("grep", args);
    assertEquals(output.toString(), "file1.txt \n");
  }

}
