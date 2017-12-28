package queueStack;

import tools.ListNode;

/**
 * Find the middle node of a singled linked list. 1. 1 -> 2 -> 3 -> null, the
 * middle node is 2 2. 1 -> 2 -> 3 -> 4 -> null, the middle node is 2 3. null,
 * the middle node is null.
 */
public class MiddleNode {
  public ListNode findMiddle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
