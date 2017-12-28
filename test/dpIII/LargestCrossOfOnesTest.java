package dpIII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LargestCrossOfOnesTest {

  LargestCrossOfOnes lc;

  @Before
  public void setUp() {
    lc = new LargestCrossOfOnes();
  }

  @Test
  public void test1() {
    int[][] matrix = { { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 1 } };
    Assert.assertEquals(2, lc.largest(matrix));
  }

  @Test
  public void test2() {
    int[][] matrix = { { 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 1, 1, 1 },
        { 0, 0, 0, 1, 1, 1 } };
    Assert.assertEquals(3, lc.largest(matrix));
  }

  @Test
  public void test3() {
    int[][] matrix = { { 0, 1 }, { 1, 1 } };
    Assert.assertEquals(0, lc.largest(matrix));
  }

  @Test
  public void test4() {
    int[][] matrix = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
    Assert.assertEquals(2, lc.largest(matrix));
  }

}
