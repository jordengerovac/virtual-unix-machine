package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JShellTest {
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
  public void testExecute() {
    String[] args = {};
    // call a command
    JShell.execute("ls", args);
    assertEquals("\n", output.toString());
  }

  public void testDoc() {
    // print documentation for a command
    JShell.doc("pwd");
    assertEquals("[pwd]\nPrints out the path of the current working "
        + "directory.\n", output.toString());
  }

  public void testHashMap() {
    // retrieve item from hashmap
    assertEquals("driver.cmd.cat", JShell.map.get("cat"));
    // retrieve item that does not exist
    assertEquals(null, JShell.map.get("asdf"));
  }

}
