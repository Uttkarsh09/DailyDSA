public class MergeTwoSortedLists {
    public static ListNode createListNodes(int[] list){
        ListNode l = new ListNode();
        ListNode temp = l;
        for(int i=0;i<list.length;i++){
            temp.next = new ListNode(list[i]);
            temp = temp.next;
        }
        return l.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l1 = MergeTwoSortedLists.createListNodes(new int[]{1,2,4});
        ListNode l2 = MergeTwoSortedLists.createListNodes(new int[]{1,3,4});
        
        ListNode ans = s.mergeTwoLists(l1, l2);

        while(ans!=null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // slower answer
        // return nonRecursiveMerge(list1, list2);

        // faster answer
        ListNode ans = new ListNode();
        recursiveMerge(list1, list2, ans);
        return ans.next;
    }

    // FASTER
    public ListNode recursiveMerge(ListNode l1, ListNode l2, ListNode ans) {
        if (l2 == null && l1 == null) {
            return ans;
        }

        if ((l1 != null) && (l2 != null)) {
            int a = l1.val;
            int b = l2.val;

            if (a < b) {
                ans.next = new ListNode(a);
                l1 = l1.next;
            } else {
                ans.next = new ListNode(b);
                l2 = l2.next;
            }
            ans = ans.next;
        }

        if (l1 == null) {
            ans.next = l2;
            return ans;
        }
        if (l2 == null) {
            ans.next = l1;
            return ans;
        }

        return recursiveMerge(l1, l2, ans);
    }

    // SLOWER
    public ListNode nonRecursiveMerge(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(), ln = ans;

        while (true) {
            if ((list1 == null) || (list2 == null)) {
                break;
            }
            if (list1.val <= list2.val) {
                ln.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                ln.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            ln = ln.next;
        }

        if (list1 == null) {
            list1 = list2;
        }

        while (list1 != null) {
            ln.next = new ListNode(list1.val);
            list1 = list1.next;
            ln = ln.next;
        }

        return ans.next;
    }
}