package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HistoryTest {
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
  public void testWriteAndRead() {
    History his = new History();
    // empty
    his.read(0);
    assertEquals("", output.toString());
    // one line
    his.write("1");
    his.read(1);
    assertEquals("1 1\n", output.toString());
    // two lines
    his.write("2");
    his.read(2);
    assertEquals("1 1\n2 2\n1 1\n", output.toString());
    // num higher than lines
    his.read(50);
    assertEquals("1 1\n2 2\n1 1\nExceeded number of commands stored.\n",
        output.toString());

  }

  public void testReadAll() {
    History his = new History();
    // empty
    his.readAll();
    assertEquals("", output.toString());
    // one line
    his.write("1");
    his.readAll();
    assertEquals("1 1\n", output.toString());
    // two lines
    his.write("2");
    his.readAll();
    assertEquals("1 1\n2 2\n1 1\n", output.toString());
  }
}
