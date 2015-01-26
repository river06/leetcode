public class IntersectLL {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode common = new ListNode(2);
        ListNode headB = new ListNode(2);
        headA.next = common;
        headB.next = common;
        ListNode result = Solution.getIntersectionNode(headA,headB);
        System.out.println(result);
    }
}