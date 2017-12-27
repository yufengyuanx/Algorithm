package sorting;

//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

  MergeSort ms;
  
  @Before
  public void setUp() {
    ms = new MergeSort();
  }
  
  @Test
  public void testNull() {
    int[] array = null;
    Assert.assertArrayEquals(null, ms.mergeSort(array));
  }
  
  @Test
  public void testEmpty() {
    int[] array = new int[0];
    Assert.assertArrayEquals(new int[0], ms.mergeSort(array));
  }
  
  @Test
  public void testSingle() {
    int[] array = new int[] {1};
    Assert.assertArrayEquals(new int[] {1}, ms.mergeSort(array));
  }
  
  @Test
  public void testEven() {
    int[] array = new int[] {2, 1};
    Assert.assertArrayEquals(new int[] {1, 2}, ms.mergeSort(array));
  }
  
  @Test
  public void testOdd() {
    int[] array = new int[] {2, 3, 1};
    Assert.assertArrayEquals(new int[] {1, 2, 3}, ms.mergeSort(array));
  }
  
  @Test
  public void testMaxValue() {
    int[] array = new int[] {Integer.MAX_VALUE};
    Assert.assertArrayEquals(new int[] {Integer.MAX_VALUE}, ms.mergeSort(array));
  }
  
  @Test
  public void testMinValue() {
    int[] array = new int[] {Integer.MIN_VALUE};
    Assert.assertArrayEquals(new int[] {Integer.MIN_VALUE}, ms.mergeSort(array));
  }
  
  @Test
  public void testMaxAndMinValue() {
    int[] array = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE,};
    Assert.assertArrayEquals(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}, ms.mergeSort(array));
  }
  
  

}
