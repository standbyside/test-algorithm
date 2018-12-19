package basic.sort.array;

/**
 * 快速排序.
 *
 * 原地排序，不稳定排序.
 */
public class QuickSort {

  public static int[] sort(int[] array) {

    if (array == null || array.length <= 1) {
      return array;
    }

    sort(array, 0, array.length - 1);

    return array;
  }

  private static void sort(int[] array, int start, int end) {

    if (start >= end) {
      return;
    }

    // 获取分区点
    int pivot = partition(array, start, end);

    sort(array, start, pivot - 1);
    sort(array, pivot + 1, end);
  }

  private static int partition(int[] array, int start, int end) {

    final int pivot = array[end];
    int i = start;

    for (int j = start; j < end; j++) {
      if (array[j] < pivot) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        ++i;
      }
    }

    int temp = array[i];
    array[i] = array[end];
    array[end] = temp;

    return i;
  }
}
