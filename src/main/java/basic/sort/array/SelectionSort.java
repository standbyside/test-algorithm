package basic.sort.array;

/**
 * 选择排序.
 */
public class SelectionSort {

  public static int[] sort(int[] array) {

    if (array == null || array.length <= 1) {
      return array;
    }
    int n = array.length;

    int min;
    int temp;

    for (int i = 0; i < n - 1; i++) {

      min = i;

      // 寻找最小值
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }

      // 交换
      temp = array[i];
      array[i] = array[min];
      array[min] = temp;
    }
    return array;
  }
}
