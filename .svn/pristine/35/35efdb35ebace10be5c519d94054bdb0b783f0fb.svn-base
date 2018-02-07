package test;

import static org.junit.Assert.*;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.Test;

public class CommandTest {

  @SuppressWarnings("deprecation")
  @Test
  public void testPathToArray() {
    Command test = new Command();
    String[] array;
    // path will NEVER start from root
    // empty path
    array = new String[] {""};
    assertEquals(array, test.pathToArray(""));
    // path with one dir
    array = new String[] {"a"};
    assertEquals(array, test.pathToArray("a"));
    // path with two dirs
    array = new String[] {"a", "b"};
    assertEquals(array, test.pathToArray("a/b"));
  }

  public void testArrayToPath() {
    Command test = new Command();
    String[] array;
    // empty array
    array = new String[] {""};
    assertEquals("/", test.arrayToPath(array));
    // array with one dir
    array = new String[] {"a"};
    assertEquals("/a", test.arrayToPath(array));
    // array with two dirs
    array = new String[] {"a", "b"};
    assertEquals("/a/b", test.arrayToPath(array));
  }

  public void testGetParentNode() {
    Command test = new Command();
    DefaultMutableTreeNode parentNode;
    parentNode = test.getParentNode("/");
    // can only test from root without running JShell
    assertEquals(null, parentNode);
    // and "this directory" of root
    parentNode = test.getParentNode(".");
    assertEquals(null, parentNode);
  }

  public void testGetWholePath() {
    Command test = new Command();
    // can only test root
    assertEquals("/", test.getWholePath("/"));
    // and "this directory" of root
    assertEquals("/", test.getWholePath("."));
  }

  public void testGetNode() {
    Command test = new Command();
    // root
    assertEquals(JShell.os.getRoot(), test.getNode("/"));
    assertEquals(JShell.os.getRoot(), test.getNode("."));
    // null parent
    assertEquals(null, test.getNode(".."));
  }

  public void testChildExists() {
    Command test = new Command();
    // no children
    assertFalse(test.childExists(JShell.os.getRoot(), "a"));
  }

  public void testBuildPath() {
    Command test = new Command();
    // root path
    assertEquals("/", test.buildPath(JShell.os.getRoot()));
  }

}
