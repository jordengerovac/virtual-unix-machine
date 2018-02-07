package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.JShell;

public class echoTest {
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
    echo cmd = new echo();
    String[] args;
    // should print "string"
    args = new String[] {"string"};
    cmd.execute(args);
    assertEquals(output.toString(), "string\n");
    // create a file
    args = new String[] {"string", ">", "file"};
    cmd.execute(args);
    assertEquals(JShell.os.getRoot().getChildCount(), 1);
    // try to overwrite a directory
    args = new String[] {"string", ">", "/"};
    cmd.execute(args);
    assertEquals(output.toString(), "string\nPath specified is a "
        + "directory.\n");
    // try to append to a directory
    args = new String[] {"string", ">>", "/"};
    cmd.execute(args);
    assertEquals(output.toString(), "string\nPath specified is a "
        + "directory.\nPath specified is a directory.\n");
  }

}
