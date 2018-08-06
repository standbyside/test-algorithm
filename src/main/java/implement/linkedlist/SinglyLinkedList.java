package implement.linkedlist;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;


/**
 * 单向链表.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SinglyLinkedList {

  private Node head;

  public SinglyLinkedList(List<Integer> list) {
    if (CollectionUtils.isEmpty(list)) {
      return;
    }
    for (Integer data : list) {
      addToTail(data);
    }
  }

  public List<Integer> dataList() {
    return dataList(head);
  }

  public static List<Integer> dataList(Node head) {
    List list = new ArrayList<>();
    Node node = head;
    while(node!= null) {
      list.add(node.data);
      node = node.next;
    }
    return list;
  }

  public Node findFirst(int data) {
    Node node = head;
    while(node != null && node.data != data) {
      node = node.next;
    }
    return node;
  }

  public Node findByIndex(int index) {
    Node node = head;
    int i = 0;
    while(node != null && i != index) {
      node = node.next;
      i++;
    }
    return node;
  }

  public void addToHead(int data) {
    head = new Node(data, head);
  }


  public void addToTail(int data) {
    if (head == null) {
      head = new Node(data);
    } else {
      Node tail = head;
      while (tail.next != null) {
        tail = tail.next;
      }
      tail.next = new Node(data);
    }
  }

  public void insertBefore(Node n, int data) {
    Node newNode = new Node(data);
    Node node = head;
    Node prev = null;
    while(node != n) {
      prev = node;
      node = node.next;
    }
    if (node == null) {
      return;
    }
    if (prev == null) {
      newNode.next = head;
      head = newNode;
    } else {
      prev.next = newNode;
      newNode.next = node;
    }
  }

  public void insertAfter(Node n, int data) {
    Node newNode = new Node(data);
    Node node = head;
    while(node != n) {
      node = node.next;
    }
    if (node == null) {
      return;
    }
    Node next = node.next;
    node.next = newNode;
    newNode.next = next;
  }


  public void delete(Node aim) {
    if (head == null) {
      return;
    }
    Node prev = null;
    Node node = head;
    while (node != null && node != aim) {
      prev = node;
      node = node.next;
    }
    delete(prev, node);
  }

  public void deleteFirst(int data) {
    if (head == null) {
      return;
    }
    Node prev = null;
    Node node = head;
    while (node != null && node.data != data) {
      prev = node;
      node = node.next;
    }
    delete(prev, node);
  }

  /**
   * 根据正序序号删除序号为index的节点.
   */
  public void deleteByAscIndex(int index) {
    if (head == null) {
      return;
    }
    Node prev = null;
    Node node = head;
    int i = 0;
    while (node != null && i != index) {
      prev = node;
      node = node.next;
      i ++;
    }
    delete(prev, node);
  }

  /**
   * 根据倒序序号删除序号为index的节点.
   */
  public void deleteByDescIndex(int index) {
    Node fast = head;
    int i = 0;
    while (fast != null && i < index) {
      fast = fast.next;
      i++;
    }
    if (fast == null) {
      return;
    }

    Node prev = null;
    Node slow = head;
    while (fast.next != null) {
      fast = fast.next;
      prev = slow;
      slow = slow.next;
    }
    if (prev == null) {
      head = head.next;
    } else {
      prev.next = slow.next;
    }
  }

  private void delete(Node prev, Node node) {
    if (node == null) {
      return;
    }
    if (prev == null) {
      // 删除的是头节点
      head = node.next;
    } else {
      prev.next = node.next;
    }
  }

  /**
   * 翻转.
   */
  public static Node reverse(Node start) {
    if (start == null || start.next == null) {
      return start;
    }
    Node prev = null;
    Node node = start;
    Node next = start.next;
    start.next = null;
    while(next != null) {
      prev = node;
      node = next;
      next = node.next;
      node.next = prev;
    }
    return node;
  }

  /**
   * 翻转.
   */
  public static Node reverse(Node start, Node end) {
    if (start == null || start.next == null) {
      return start;
    }
    Node prev = null;
    Node node = start;
    Node next = start.next;
    start.next = null;
    while(next != null && node != end) {
      prev = node;
      node = next;
      next = node.next;
      node.next = prev;
    }
    return node;
  }

  /**
   * 比较.
   */
  public static boolean compareNodeLink(Node n1, Node n2) {
    Node node1 = n1;
    Node node2 = n2;
    while(node1 != null && node2 != null) {
      if (n1.data != n2.data) {
        return false;
      }
      node1 = node1.next;
      node2 = node2.next;
    }
    return node1 == null && node2 == null;
  }

  /**
   * 判断是否为回文.
   *
   * 1.快慢指针法找到中间节点.
   * 2.翻转左半部分.
   * 3.翻转后的左半部分与右半部分做比较.
   */
  public static boolean palindrome1(Node head) {
    if (head == null) {
      return false;
    }
    // 只有一个节点
    if (head.next == null) {
      return true;
    }

    // 快慢指针法找到中间节点
    Node node1 = head;
    Node node2 = head;
    while (node2.next != null && node2.next.next != null) {
      // 慢指针，前进1步
      node1 = node1.next;
      // 快指针，前进2步
      node2 = node2.next.next;
    }

    Node right = node1.next;
    Node left = reverse(head, node1);
    // 翻转左边
    if (node2.next == null) {
      // 奇数个节点
      left = left.next;
    }
    return compareNodeLink(left, right);
  }

  /**
   * 判断是否为回文.
   *
   * 1.快慢指针法找到中间节点，同时生成一个左半部分反序的链表.
   * 2.左半部分与右半部分做比较.
   *
   * https://github.com/andavid/leetcode-java/blob/master/note/234/README.md
   */
  public static boolean palindrome2(Node head) {
    if (head == null) {
      return false;
    }
    // 只有一个节点
    if (head.next == null) {
      return true;
    }

    Node prev = null;
    Node next = null;
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }

    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      if (slow.data != prev.data) {
        return false;
      }
      slow = slow.next;
      prev = prev.next;
    }

    return true;
  }

  /**
   * 判断是否是一个环.
   */
  public static boolean circle(Node head) {
    if (head == null) {
      return false;
    }
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public static Node mergeSortedList(Node head1, Node head2) {
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }

    Node head;
    Node node1 = head1;
    Node node2 = head2;

    if (node1.data < node2.data) {
      head = node1;
      node1 = node1.next;
    } else {
      head = node2;
      node2 = node2.next;
    }
    // 头节点指针不可以移动，移动了就丢失了
    Node node = head;

    // 这里不能用 || ，否则下一行会报空指针
    while (node1 != null && node2 != null) {
      if (node1.data < node2.data) {
        node.next = node1;
        node1 = node1.next;
      } else {
        node.next = node2;
        node2 = node2.next;
      }
      node = node.next;
    }

    // 处理当某链表到达尽头后，另一个链表的余下部分
    if (node1 != null) {
      node.next = node1;
    } else {
      node.next = node2;
    }

    return head;
  }

  /**
   * 获取中间节点.
   */
  public static Node middleNode(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  @Data
  @ToString
  public class Node {

    /**
     * 数据.
     */
    private int data;
    /**
     * 后继指针.
     */
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    public Node(int data) {
      this.data = data;
    }
  }
}
