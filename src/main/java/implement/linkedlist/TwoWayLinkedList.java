package implement.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 双向链表.
 */
@Data
@ToString
public class TwoWayLinkedList<T> {

  /**
   * 头节点.
   */
  private Node head;
  /**
   * 尾节点.
   */
  private Node tail;
  /**
   * 链表长度.
   */
  private int length = 0;


  public TwoWayLinkedList() {

  }

  public Node put(int data) {
    Node newNode = new Node(tail, data);
    tail = newNode;
    length ++;
    return newNode;
  }

  public Node deleteFirst(int data) {
    Node node = deleteFirst(head, data);
    if (node != null) {
      length--;
      if (tail == node) {

      }
    }
    return node;
  }

  public Node deleteFirst(Node node, int data) {
    Node find = getFirstEqual(node, data);
    if (find == null) {
      return null;
    }
    find.deleteSelf();
    return node;
  }

  public int deleteAll(int data) {

    return 0;
  }


  private Node getFirstEqual(Node node, int data) {
    if (node == null) {
      return null;
    }
    return node.data == data ? node : getFirstEqual(node.getNext(), data);
  }



  /**
   * 节点.
   */
  @Data
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  class Node {

    /**
     * 前驱指针.
     */
    private Node prev;
    /**
     * 数据.
     */
    private int data;
    /**
     * 后继指针.
     */
    private Node next;

    public Node(Node prev, int data) {
      this.prev = prev;
      this.data = data;
    }

    public void deleteSelf() {
      if (prev != null) {
        prev.setNext(next);
      }
      if (next != null) {
        next.setPrev(prev);
      }
    }
  }
}
