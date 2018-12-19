package basic.sort.array;

/**
 * 归并排序.
 *
 * 时间复杂度是 O(nlogn)，空间复杂度是 O(n)，稳定排序.
 */
public class MergeSort {

  public static int[] sort(int[] array) {

    if (array == null || array.length <= 1) {
      return array;
    }

    sort(array, 0, array.length - 1);

    return array;
  }

  /**
   * 递归调用函数.
   */
  private static void sort(int[] array, int start, int end) {

    // 递归终止条件
    if (start >= end) {
      return;
    }

    // 取start到end之间的中间位置middle，防止（start + end）的和超过int类型最大值
    int middle = start + (end - start) / 2;

    // 分治递归
    sort(array, start, middle);
    sort(array, middle + 1, end);

    // 将array[start...middle]和array[middle+1...end]合并为array[start...end]
    merge(array, start, middle, end);
  }

  /**
   * 合并.
   */
  private static void merge(int[] array, int start, int middle, int end) {

    // 前半部分数组的索引
    int i1 = start;
    // 后半部分数组的索引
    int i2 = middle + 1;
    // temp的索引
    int i3 = 0;

    // 申请一个大小跟array[start...end]一样的临时数组
    int[] temp = new int[end - start + 1];

    while (i1 <= middle && i2 <= end) {
      if (array[i1] <= array[i2]) {
        temp[i3++] = array[i1++];
      } else {
        temp[i3++] = array[i2++];
      }
    }

    // 判断哪个子数组中有剩余的数据
    int s = i1;
    int e = middle;
    // 后半部分索引未到达结尾，后半部分数组有剩余
    if (i2 <= end) {
      s = i2;
      e = end;
    }

    // 将剩余的数据拷贝到临时数组temp
    while (s <= e) {
      temp[i3++] = array[s++];
    }

    // 将temp中的数组拷贝回array[start...end]
    for (i1 = 0; i1 <= end - start; i1++) {
      array[start + i1] = temp[i1];
    }
  }
}
