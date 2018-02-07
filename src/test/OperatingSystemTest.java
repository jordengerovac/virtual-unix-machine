package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperatingSystemTest {

  @Test
  public void testConstructor() {
    OperatingSystem os = new OperatingSystem();
    // check if cwd = root at init
    assertEquals(os.getRoot(), os.getLocation());
  }

  public void testSetLocation() {
    OperatingSystem os = new OperatingSystem();
    // set location to root
    os.setLocation(os.getRoot());
    assertEquals(os.getRoot(), os.getLocation());
    // set location to itself, which is root
    os.setLocation(os.getLocation());
    assertEquals(os.getRoot(), os.getLocation());
  }

  public void testGetLocation() {
    OperatingSystem os = new OperatingSystem();
    // root = cwd
    assertEquals(os.getRoot(), os.getLocation());
  }
}
