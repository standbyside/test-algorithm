package basic.search;

/**
 * 二分查找.
 */
public class BinarySearch {


  public static int search(int[] array, int value) {

    if (array == null) {
      return -1;
    }

    int low = 0;
    int high = array.length - 1;
    int mid;

    while (low <= high) {
      mid = low + (high - low) / 2;
      if (array[mid] == value) {
        return mid;
      }
      if (array[mid] > value) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }
}
