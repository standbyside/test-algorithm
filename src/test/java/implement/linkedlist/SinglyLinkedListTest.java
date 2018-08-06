package implement.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.jupiter.api.Test;



/**
 * 单向链表单元测试.
 *
 * @author zhaona
 * @create 2018/11/29 4:53 PM
 */
public class SinglyLinkedListTest {

  @Test
  public void testDataList() {
    List<Integer> expected = Lists.newArrayList(2, 5, 7, 9, 1);

    List<Integer> actual = initList().dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testFindFirst() {
    Integer expected = 1;

    Integer actual = initList().findFirst(1).getData();

    assertEquals(expected, actual);
  }

  @Test
  public void testFindByIndex() {
    Integer expected = 7;

    Integer actual = initList().findByIndex(2).getData();

    assertEquals(expected, actual);
  }

  @Test
  public void testAddToHead() {
    List<Integer> expected = Lists.newArrayList(18, 2, 5, 7, 9, 1);

    SinglyLinkedList list = initList();
    list.addToHead(18);
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testAddToTail() {
    List<Integer> expected = Lists.newArrayList(2, 5, 7, 9, 1, 11);

    SinglyLinkedList list = initList();
    list.addToTail(11);
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testInsertBefore() {
    List<Integer> expected = Lists.newArrayList(2, 3, 5, 7, 9, 1);

    SinglyLinkedList list = initList();
    list.insertBefore(list.findFirst(5), 3);
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testInsertAfter() {
    List<Integer> expected = Lists.newArrayList(2, 5, 3, 7, 9, 1);

    SinglyLinkedList list = initList();
    list.insertAfter(list.findFirst(5), 3);
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testDelete() {
    List<Integer> expected = Lists.newArrayList(2, 5, 7, 1);

    SinglyLinkedList list = initList();
    list.delete(list.findByIndex(3));
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testDeleteFirst() {
    List<Integer> expected = Lists.newArrayList(2, 5, 9, 1);

    SinglyLinkedList list = initList();
    list.deleteFirst(7);
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testDeleteByAscIndex() {
    List<Integer> expected = Lists.newArrayList(5, 7, 9, 1);

    SinglyLinkedList list = initList();
    list.deleteByAscIndex(0);
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testDeleteByDescIndex() {

    /**
     * 1.
     */
    List<Integer> expected = Lists.newArrayList(2, 5, 7, 1);

    SinglyLinkedList list = initList();
    list.deleteByDescIndex(1);
    List<Integer> actual = list.dataList();

    assertEquals(expected, actual);

    /**
     * 2.
     */
    expected = Lists.newArrayList(2, 5, 7, 9, 1);

    list = initList();
    list.deleteByDescIndex(9);
    actual = list.dataList();

    assertEquals(expected, actual);

    /**
     * 3.
     */
    expected = Lists.newArrayList(5, 7, 9, 1);

    list = initList();
    list.deleteByDescIndex(4);
    actual = list.dataList();

    assertEquals(expected, actual);
  }

  @Test
  public void testReverse1() {
    List<Integer> expected = Lists.newArrayList(1, 9, 7, 5, 2);

    SinglyLinkedList list = initList();
    SinglyLinkedList.Node node = SinglyLinkedList.reverse(list.getHead());
    List<Integer> actual = list.dataList(node);

    assertEquals(expected, actual);
  }

  @Test
  public void testReverse2() {
    List<Integer> expected = Lists.newArrayList(9, 7, 5, 2);

    SinglyLinkedList list = initList();
    SinglyLinkedList.Node node = SinglyLinkedList.reverse(list.getHead(), list.findByIndex(3));
    List<Integer> actual = list.dataList(node);

    assertEquals(expected, actual);
  }

  @Test
  public void testCompareNodeLink() {
    SinglyLinkedList list1 = initList();
    SinglyLinkedList list2 = initList();
    assertEquals(true, SinglyLinkedList.compareNodeLink(list1.getHead(), list2.getHead()));

    list2.deleteFirst(2);
    assertEquals(false, SinglyLinkedList.compareNodeLink(list1.getHead(), list2.getHead()));
  }


  @Test
  public void testPalindrome1() {
    SinglyLinkedList list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 9, 1
    ));
    assertEquals(false, SinglyLinkedList.palindrome1(list.getHead()));

    list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 5, 2
    ));
    assertEquals(true, SinglyLinkedList.palindrome1(list.getHead()));

    list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 5, 2, 0
    ));
    assertEquals(false, SinglyLinkedList.palindrome1(list.getHead()));


    list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 7, 5, 2
    ));
    assertEquals(true, SinglyLinkedList.palindrome1(list.getHead()));
  }

  @Test
  public void testPalindrome2() {
    SinglyLinkedList list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 9, 1
    ));
    assertEquals(false, SinglyLinkedList.palindrome2(list.getHead()));

    list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 5, 2
    ));
    assertEquals(true, SinglyLinkedList.palindrome2(list.getHead()));

    list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 5, 2, 0
    ));
    assertEquals(false, SinglyLinkedList.palindrome2(list.getHead()));


    list = new SinglyLinkedList(Lists.newArrayList(
        2, 5, 7, 7, 5, 2
    ));
    assertEquals(true, SinglyLinkedList.palindrome2(list.getHead()));
  }

  @Test
  public void testCircle() {
    SinglyLinkedList list = initList();
    assertEquals(false, SinglyLinkedList.circle(list.getHead()));

    list.findByIndex(4).setNext(list.getHead());
    assertEquals(true, SinglyLinkedList.circle(list.getHead()));
  }

  @Test
  public void testMergeSortedList() {
    /**
     * 1. 1长2短.
     */
    List<Integer> expected = Lists.newArrayList(1, 2, 2, 4, 5, 5, 7, 8, 9, 10, 11);

    SinglyLinkedList.Node node = SinglyLinkedList.mergeSortedList(
        new SinglyLinkedList(Lists.newArrayList(1, 2, 5, 5, 9, 10, 11)).getHead(),
        new SinglyLinkedList(Lists.newArrayList(2, 4, 7, 8)).getHead()
    );
    List<Integer> actual = SinglyLinkedList.dataList(node);

    assertEquals(expected, actual);

    /**
     * 2. 1短2长.
     */
    expected = Lists.newArrayList(1, 2, 2, 4, 5, 5, 7, 8, 9, 11, 11);

    node = SinglyLinkedList.mergeSortedList(
        new SinglyLinkedList(Lists.newArrayList(1, 2, 5, 5)).getHead(),
        new SinglyLinkedList(Lists.newArrayList(2, 4, 7, 8, 9, 11, 11)).getHead()
    );
    actual = SinglyLinkedList.dataList(node);

    assertEquals(expected, actual);
  }

  @Test
  public void testMiddleNode() {
    SinglyLinkedList.Node node = SinglyLinkedList.middleNode(
        new SinglyLinkedList(Lists.newArrayList(2, 5, 7, 9, 1)).getHead()
    );
    assertEquals(7, node.getData());

    node = SinglyLinkedList.middleNode(
        new SinglyLinkedList(Lists.newArrayList(2, 5, 7, 7, 9, 1)).getHead()
    );
    assertEquals(7, node.getData());
  }

  private SinglyLinkedList initList() {
    return new SinglyLinkedList(Lists.newArrayList(2, 5, 7, 9, 1));
  }
}
