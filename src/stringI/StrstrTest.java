package stringI;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 1. null, null 2. null, empty 3. empty, empty 3. empty, null 4. longer,
 * shorter 5. shorter, longer 6. same
 * 
 * 
 *
 */
public class StrstrTest {

  Strstr ss;

  @Before
  public void setUp() {
    ss = new Strstr();
  }

  @Test
  public void test1() {
    int result = ss.strstr(null, null);
    assertEquals(-1, result);
  }

  @Test
  public void test2() {
    int result = ss.strstr(null, "");
    assertEquals(-1, result);
  }

  @Test
  public void test3() {
    int result = ss.strstr("", null);
    assertEquals(-1, result);
  }

  @Test
  public void test4() {
    int result = ss.strstr("", "");
    assertEquals(0, result);
  }

  @Test
  public void test5() {
    int result = ss.strstr("ab", "a");
    assertEquals(0, result);
  }

  @Test
  public void test6() {
    int result = ss.strstr("a", "ab");
    assertEquals(-1, result);
  }

  @Test
  public void test7() {
    int result = ss.strstr("ab", "ab");
    assertEquals(0, result);
  }

  @Test
  public void test8() {
    int result = ss.strstr("abc", "c");
    assertEquals(2, result);
  }

  @Test
  public void test9() {
    int result = ss.strstr("abcdef", "abcef");
    assertEquals(-1, result);
  }

}
