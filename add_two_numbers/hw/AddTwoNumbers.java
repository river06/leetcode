package hw;

public class AddTwoNumbers{
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        
        ListNode result = Solution.addTwoNumbers(l1,l2);
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}