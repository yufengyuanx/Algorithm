package advancedV;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LargestLengthProductTest {
  
  LargestLengthProduct llp;
  
  @Before
  public void setUp() {
    llp = new LargestLengthProduct();
  }

  @Test
  public void test1() {
    int res = llp.largestProduct(new String[] {"abc", "a"});
    assertEquals(res, 0);
  }
  
  @Test
  public void test2() {
    int res = llp.largestProduct(new String[] {"abc", "def"});
    assertEquals(res, 9);
  }
  
  @Test
  public void test3() {
    int res = llp.largestProduct(new String[] {"abc", "de"});
    assertEquals(res, 6);
  }
  
  @Test
  public void test4() {
    int res = llp.largestProduct(new String[] {"abc", "cde"});
    assertEquals(res, 0);
  }

}
