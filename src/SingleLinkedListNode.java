import java.util.InputMismatchException;
import java.util.Scanner;

 class SingleLinkedListNode {
        int data;
        SingleLinkedListNode next;
        SingleLinkedListNode(int data, SingleLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
     static void printList(SingleLinkedListNode head) {
        SingleLinkedListNode ptr = head;
        System.out.println("Please, input the desired number of max values in list: ");
        int number;
        try (Scanner scanner = new Scanner(System.in)) {
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Number is less than zero ");
            }

            for (int i = 0; i < number; i++) {
                if (ptr == null) {
                    System.out.println("Number is greater than list size");
                    break;
                }
                System.out.print(ptr.data + "  ");
                ptr = ptr.next;
            }
        } catch (InputMismatchException | NullPointerException e) {
            System.out.println("Input value is incorrect: " + e);
        }
    }

    // Merge two sublists in one list
     static SingleLinkedListNode sortedMerge(SingleLinkedListNode a, SingleLinkedListNode b) {
        // base cases
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        SingleLinkedListNode result;

        if (a.data >= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

     static SingleLinkedListNode[] frontBackSplit(SingleLinkedListNode source) {
        if (source == null || source.next == null) {
            return new SingleLinkedListNode[]{source, null};
        }

        SingleLinkedListNode slow = source;
        SingleLinkedListNode fast = source.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        SingleLinkedListNode[] arr = new SingleLinkedListNode[]{source, slow.next};
        slow.next = null;

        return arr;
    }

    // Sort single linked list using the merge-sort algorithm
   static SingleLinkedListNode mergesort(SingleLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        SingleLinkedListNode[] arr = frontBackSplit(head);
        SingleLinkedListNode front = arr[0];
        SingleLinkedListNode back = arr[1];

        front = mergesort(front);
        back = mergesort(back);

        return sortedMerge(front, back);
    }
}
