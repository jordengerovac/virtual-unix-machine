package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class historyTest {
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
    history cmd = new history();
    String[] args;
    // readall
    args = new String[] {};
    cmd.execute(args);
    assertEquals("", output.toString());
    // read 0
    args = new String[] {"0"};
    cmd.execute(args);
    assertEquals("", output.toString());
  }

}
