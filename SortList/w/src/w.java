
public class w {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test case
		ListNode head = new ListNode(-84);
		ListNode lala = head;
		//head.next = new ListNode(2);
		//head.next.next = new ListNode(1);
		
		int[] testArray = {142,41,-17,-71,170,186,183,-21,-76,76,10,29,81,112,-39,-6,-43,58,41,111,33,69,97,-38,82,-44,-7,99,135,42,150,149,-21,-30,164,153,92,180,-61,99,-81,147,109,34,98,14,178,105,5,43,46,40,-37,23,16,123,-53,34,192,-73,94,39,96,115,88,-31,-96,106,131,64,189,-91,-34,-56,-22,105,104,22,-31,-43,90,96,65,-85,184,85,90,118,152,-31,161,22,104,-85,160,120,-31,144,115};
		
		for(int j=0;j<testArray.length-1;j++){
			lala.next = new ListNode(testArray[j]);
			lala = lala.next;
		}
		
		printNodeList(head);
		System.out.print('\n');
		
		ListNode solution = Solution2.sortList(head);
		printNodeList(solution);
		
		//System.out.print(head.val);
	
	}
	
	private static void printNodeList( ListNode head) {
		while(head != null) {
			System.out.print(head.val);
			System.out.print(" ");
			head = head.next;
		}
	}

}

