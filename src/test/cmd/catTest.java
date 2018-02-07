package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class catTest {
  private final ByteArrayOutputStream output = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(output));
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
  }

  @Test(expected = Exception.class)
  /**
   * Tests various argument cases.
   */
  public void testExecute() {
    cat cmd = new cat();
    String[] args;
    // empty should return printed error
    args = new String[] {};
    cmd.execute(args);
    assertEquals("Invalid command, please try again.\n", output.toString());
    // invalid file should throw exception
    args = new String[] {"/"};
    cmd.execute(args);
    assertEquals(null, output.toString());

  }

}
