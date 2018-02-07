package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class pwdTest {
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
    pwd cmd = new pwd();
    String[] args;
    // pwd
    args = new String[] {};
    cmd.execute(args);
    assertEquals(output.toString(), "/\n");
    // passing invalid argument
    args = new String[] {"a"};
    cmd.execute(args);
    assertEquals(output.toString(), "/\nInvalid command, please"
        + " try again.\n");
  }

}
