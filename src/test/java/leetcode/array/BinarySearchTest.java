package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BinarySearchTest {

  @Test
  public void test1() {

    int actual = BinarySearch.search1(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    assertEquals(4, actual);

    actual = BinarySearch.search1(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    assertEquals(-1, actual);
  }

  @Test
  public void test2() {

    int actual = BinarySearch.search2(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    assertEquals(4, actual);

    actual = BinarySearch.search2(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    assertEquals(-1, actual);
  }

  @Test
  public void test3() {

    int actual = BinarySearch.search3(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    assertEquals(4, actual);

    actual = BinarySearch.search3(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    assertEquals(-1, actual);
  }
}
