package basic.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * 二分查找.
 */
public class BinarySearchTest {

  @Test
  public void testSearch() {
    int[] array = new int[]{1, 2, 4, 7, 9, 10, 11};
    int expected = 2;
    int actual = BinarySearch.search(array, 4);
    assertEquals(expected, actual);
  }
}
