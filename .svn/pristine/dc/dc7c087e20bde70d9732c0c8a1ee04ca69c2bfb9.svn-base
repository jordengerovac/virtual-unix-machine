package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class manTest {
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
    man cmd = new man();
    String[] args;
    // documentation for man
    args = new String[] {"man"};
    cmd.execute(args);
    assertEquals(output.toString(), "[man cmd]\nPrints out documentation for "
        + "the specified\ncommand.\n");

  }

}
