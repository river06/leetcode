package hw;

public class PopulateNextPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeLinkNode root = new TreeLinkNode(1);
		root.right = new TreeLinkNode(2);
		root.left = new TreeLinkNode(3);
		Solution.connect(root);

	}

}
