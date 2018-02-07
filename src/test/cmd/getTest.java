package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.JShell;

public class getTest {
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
    // get file from url
    args = new String[] {"http://www.twitter.com/file1.txt"};
    JShell.execute("get", args);
    // list file in current directory
    args = new String[] {};
    JShell.execute("ls", args);
    assertEquals(output.toString(), "file1.txt \n");
  }

}
