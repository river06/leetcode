public class Solution{
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        // the idea is that linked lists have same length?
        // get length of list1 and list2
        ListNode pA = headA;
        ListNode pB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(pA != null) {
            pA = pA.next;
            lengthA ++;
        }
        
        while(pB != null) {
            pB = pB.next;
            lengthB ++;
        }
        
        pA = headA;
        pB = headB;
        if(lengthA>=lengthB) {
            for(int i=0;i<lengthA-lengthB; i++) {
                pA = pA.next;
            }
        } else {
            for(int i=0; i<lengthB-lengthA; i++) {
                pB = pB.next;
            }
        }
        
        ListNode pC = null;
        while(pA != null) {
            if(pA == pB) {
                pC = pA;
                break;
            } else {
                pA = pA.next;
                pB = pB.next;
            }
        }
        
        return pC;
    }
}