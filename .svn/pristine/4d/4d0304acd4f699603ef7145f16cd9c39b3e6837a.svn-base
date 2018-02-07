package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

public class FileTest {
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
  public void testGetName() {
    File file;
    // check empty name
    file = new File("");
    assertEquals("", file.getName());
    // check name
    file = new File("name");
    assertEquals("name", file.getName());
  }

  public void testWriteAndReadAll() {
    File file = new File("name");
    // empty
    file.readAll();
    assertEquals("", output.toString());
    // one string
    file.write("string");
    file.readAll();
    assertEquals("string", output.toString());
    // two strings
    file.write("string");
    file.readAll();
    assertEquals("string\nstring", output.toString());
  }

}
