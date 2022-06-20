class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next.next;
    int length = 0;

    while (fast != null || fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        length = calculateCycleLength(slow);
        break;
      }
    }

    return cycleStart(length, head);
  }

  public static ListNode cycleStart(int length, ListNode head) {
    ListNode pointer1 = head;
    ListNode pointer2 = head;

    while (length > 0) {
      pointer1 = pointer1.next;
      length--;
    }

    while (pointer1 != pointer2) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }

    return pointer2;
  }

  public static int calculateCycleLength(ListNode slow) {
    int length = 1;
    ListNode current = slow.next;

    while (current != slow) {
      current = current.next;
      length++;
    }
    return length;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}