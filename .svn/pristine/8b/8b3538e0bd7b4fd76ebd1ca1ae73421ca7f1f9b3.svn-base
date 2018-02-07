package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.JShell;

public class cdTest {
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
  public void testExecute() {
    cd cmd = new cd();
    String[] args;
    // set to root
    args = new String[] {"/"};
    cmd.execute(args);
    assertEquals(JShell.os.getLocation(), JShell.os.getRoot());
    // set to itself at root
    args = new String[] {".."};
    cmd.execute(args);
    assertEquals(JShell.os.getLocation(), JShell.os.getRoot());
  }

}
