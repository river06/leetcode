
public class w {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test case
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		
		System.out.print(head.val);
	
	}
	
	private void printNodeList( ListNode head) {
		while(head != null) {
			System.out.print(head.val);
			System.out.print(" ");
			
		}
	}

}

