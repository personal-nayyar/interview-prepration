package code.problems.linkedList;

public class LongestDecreasingSubarrayLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findLongestDecreasingSubList(ListNode head) {
        ListNode longestSubListStart = head;
        ListNode longestSubListEnd = head;
        ListNode current = head;

        while (current != null) {
            ListNode currentStart = current;
            ListNode currentEnd = current;

            while (current.next != null && current.next.val < current.val) {
                currentEnd = current.next;
                current = current.next;
            }
            
            if (currentEnd != currentStart) {
                if (getLength(currentStart, currentEnd) > getLength(longestSubListStart, longestSubListEnd)) {
                    longestSubListStart = currentStart;
                    longestSubListEnd = currentEnd;
                }
            }

            current = current.next;
        }
        
        // Adjust longestSubListEnd to ensure it points to the last node of the subsequence
        while (longestSubListEnd.next != null && longestSubListEnd.next.val < longestSubListEnd.val) {
            longestSubListEnd = longestSubListEnd.next;
        }

        // Disconnect the longest subsequence from the original list
        if (longestSubListEnd != null) {
            longestSubListEnd.next = null;
        }

        return longestSubListStart;
    }

    private static int getLength(ListNode start, ListNode end) {
        int length = 0;
        while (start != end) {
            length++;
            start = start.next;
        }
        return length + 1; // Add 1 to include the end node
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        ListNode longestSubListStart = findLongestDecreasingSubList(head);

        System.out.println("Longest decreasing subsequence:");
        printList(longestSubListStart);
    }
}
