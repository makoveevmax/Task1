public class Main {
    private static SingleLinkedListNode getNode(int[] keys) {
        SingleLinkedListNode head = null;
        for (int key : keys) {
            head = new SingleLinkedListNode(key, head);
        }
        return head;
    }

    public static void main(String[] args) {
        int[] keys = {5, 2, 4, 1};
        SingleLinkedListNode head = getNode(keys);

        head = SingleLinkedListNode.mergesort(head);
        SingleLinkedListNode.printList(head);
    }
}
