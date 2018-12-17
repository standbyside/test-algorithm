package basic.sort.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


/**
 * 数组排序单元测试.
 */
public class SortTest {

  @Test
  public void testBubbleSort() {
    int[] array = new int[] {3, 5, 4, 1, 2, 6};
    int[] expected = new int[] {1, 2, 3, 4, 5, 6};
    int[] actual = BubbleSort.sort(array);
    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
  }

  @Test
  public void testInsertionSort() {
    int[] array = new int[] {3, 5, 4, 1, 2, 6};
    int[] expected = new int[] {1, 2, 3, 4, 5, 6};
    int[] actual = InsertionSort.sort(array);
    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
  }

  @Test
  public void testSelectionSort() {
    int[] array = new int[] {3, 5, 4, 1, 2, 6};
    int[] expected = new int[] {1, 2, 3, 4, 5, 6};
    int[] actual = SelectionSort.sort(array);
    assertEquals(Arrays.toString(expected), Arrays.toString(actual));
  }
}
