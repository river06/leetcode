/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

package hw;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = null;
        ListNode p3 = null;
        
        int carry = 0;
        int iter = 1;
        
        while(p1!=null || p2!=null || carry !=0) {
            int val1 = 0;
            if(p1!=null) {
                val1 = p1.val;
                p1 = p1.next;
            }
            
            int val2 = 0;
            if(p2!=null) {
                val2 = p2.val;
                p2 = p2.next;
            }
            
            int sum = (val1 + val2 + carry)%10;
            carry = (val1 + val2 + carry)/10;
            
            if(iter == 1) {
                result = new ListNode(sum);
                p3 = result;
                iter ++;
            } else {
                p3.next = new ListNode(sum);
                p3 = p3.next;
                
            }
            
        }
        return result;
    }
}