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
  private Node<T> head;
  /**
   * 尾节点.
   */
  private Node<T> tail;
  /**
   * 链表长度.
   */
  private int length = 0;


  public TwoWayLinkedList() {
    // 这里如果用了哨兵节点，在判断data为null的节点时，都需要额外处理
  }

  public Node put(T data) {
    Node newNode = new Node(tail, data);
    tail = newNode;
    length ++;
    return newNode;
  }

  public Node deleteFirst(T data) {
    Node node = deleteFirst(head, data);
    if (node != null) {
      length--;
      if (tail == node) {

      }
    }
    return node;
  }

  public Node deleteFirst(Node node, T data) {
    Node find = getFirstEqual(node, data);
    if (find == null) {
      return null;
    }
    find.deleteSelf();
    return node;
  }

  public int deleteAll(T data) {

    return 0;
  }


  private Node getFirstEqual(Node node, T data) {
    if (node == null) {
      return null;
    }
    return node.dataEqual(data) ? node : getFirstEqual(node.getNext(), data);
  }



  /**
   * 节点.
   */
  @Data
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  class Node<T> {

    /**
     * 前驱指针.
     */
    private Node prev;
    /**
     * 数据.
     */
    private T data;
    /**
     * 后继指针.
     */
    private Node next;

    public Node(Node prev, T data) {
      this.prev = prev;
      this.data = data;
    }

    public boolean dataEqual(T data) {
      return this.data == null ? (data == null) : this.data.equals(data);
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
