package leetcode.array;

import java.util.TreeMap;

/**
 * No.704  Easy
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 *
 * 【Example 1】:
 *
 *    Input: nums = [-1, 0, 3, 5, 9, 12], target = 9
 *    Output: 4
 *    Explanation: 9 exists in nums and its index is 4
 *
 * 【Example 2】:
 *
 *    Input: nums = [-1, 0, 3, 5, 9, 12], target = 2
 *    Output: -1
 *    Explanation: 2 does not exist in nums so return -1
 *
 * 【Note】:
 *
 *     1. You may assume that all elements in nums are unique.
 *     2. n will be in the range [1, 10000].
 *     3. The value of each element in nums will be in the range [-9999, 9999].
 *
 * @author zhaona
 * @create 2018/8/6 上午10:19
 */
public class BinarySearch {

  public static int search1(int[] nums, int target) {
    if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length-1]) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int index = (right + left)/2;
    while(true) {
      if (nums[index] == target) {
        return index;
      } else if (nums[index] > target) {
        right = index - 1;
      } else {
        left = index + 1;
      }
      if (index == (right + left)/2) {
        break;
      }
      index = (right + left)/2;
    }
    return -1;
  }

  public static int search2(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (right + left) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] > target) right = mid - 1;
      else left = mid + 1;
    }
    return -1;
  }

  public static int search3(int[] nums, int target) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
    for (int i=0;i<nums.length;i++) {
      treeMap.put(nums[i], i);
    }
    Integer index = treeMap.get(target);
    return index == null ? -1 : index;
  }
}
