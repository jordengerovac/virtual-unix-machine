package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectoryTest {

  @Test
  public void testGetName() {
    Directory dir;
    // check empty name
    dir = new Directory("");
    assertEquals("", dir.getName());
    // check name
    dir = new Directory("name");
    assertEquals("name", dir.getName());
  }

}
