package basic.sort.array;

/**
 * 插入排序.
 *
 * 空间复杂度为 O(1)，是一个原地排序算法.
 * 相邻两个元素大小相等时不做交换，是一个稳定排序算法.
 * 最好情况时，要排序的数据已经是有序的了，时间复杂度是 O(n).
 * 最坏情况时，要排序的数据刚好是倒序排列的，时间复杂度为 O(n^2).
 * 平均情况下的时间复杂度就是 O(n^2).
 */
public class InsertionSort {

  public static int[] sort(int[] array) {

    if (array == null || array.length <= 1) {
      return array;
    }

    int n = array.length;

    int value;

    for (int i = 1; i < n; i++) {

      value = array[i];
      // 因为后面的位置比较多，根据比较结果可以当即向后移动，所以从已序数组的后面开始比较
      int j = i - 1;

      for (; j >= 0; j--) {
        if (array[j] > value) {
          // 大于目标值的向后移动，为目标值腾出位置
          array[j + 1] = array[j];
        } else {
          break;
        }
        array[j] = value;
      }
    }

    return array;
  }
}
