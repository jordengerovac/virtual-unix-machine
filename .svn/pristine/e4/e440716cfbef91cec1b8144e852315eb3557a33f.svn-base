package test.cmd;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.JShell;

public class pushdpopdTest {
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
   * Tests various argument cases for push and pop returns.
   */
  public void testExecute() {
    pushd push = new pushd();
    popd pop = new popd();
    String[] args;
    // push root and change cwd to root
    args = new String[] {"/"};
    push.execute(args);
    assertEquals(JShell.os.getLocation(), JShell.os.getRoot());
    // push root and change cwd to .
    args = new String[] {"."};
    push.execute(args);
    assertEquals(JShell.os.getLocation(), JShell.os.getRoot());
    // push nonexistent directory
    args = new String[] {"a"};
    push.execute(args);
    assertEquals(output.toString(), "Specified directory does not exist.\n");
    // pop root out
    args = new String[] {};
    pop.execute(args);
    assertEquals(JShell.os.getLocation(), JShell.os.getRoot());
    // pop again
    pop.execute(args);
    assertEquals(JShell.os.getLocation(), JShell.os.getRoot());
    // pop empty stack
    pop.execute(args);
    assertEquals(output.toString(), "Specified directory does not exist.\n"
        + "Directory stack is empty.\n");
  }

}
