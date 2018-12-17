package basic.sort.array;

/**
 * 冒泡排序.
 *
 * 空间复杂度为 O(1)，是一个原地排序算法.
 * 相邻两个元素大小相等时不做交换，是一个稳定排序算法.
 * 最好情况时，要排序的数据已经是有序的了，时间复杂度是 O(n).
 * 最坏情况时，要排序的数据刚好是倒序排列的，时间复杂度为 O(n^2).
 * 平均情况下的时间复杂度就是 O(n^2).
 *
 * 有序度是数组中具有有序关系的元素对的个数.
 * 满有序度为 n*(n-1)/2.
 * 逆序度 = 满有序度 - 有序度.
 */
public class BubbleSort {

  public static int[] sort(int[] array) {

    if (array == null || array.length <= 1) {
      return array;
    }

    int n = array.length;

    int temp;

    for (int i = 0; i < n; i++) {

      // 交换
      boolean changed = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          changed = true;
        }
      }

      // 没有数据交换，提前退出
      if (!changed) {
        break;
      }
    }

    return array;
  }
}
