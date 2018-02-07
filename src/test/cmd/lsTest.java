package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class lsTest {
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
    ls cmd = new ls();
    String[] args;
    // empty node
    args = new String[] {};
    cmd.execute(args);
    assertEquals(output.toString(), "");
    // root node
    args = new String[] {"/"};
    cmd.execute(args);
    assertEquals(output.toString(), "/:"+s);
    // recursive check at root
    args = new String[] {"-R"};
    cmd.execute(args);
    assertEquals(output.toString(), "/:"+s+"/:"+s);
    // multiple directories
    args = new String[] {"/", "/"};
    cmd.execute(args);
    assertEquals(output.toString(), "/:"+s+"/:"+s+"/:"+s+"/:"+s);
  }

}
