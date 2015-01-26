import java.util.*;

public class BinaryTreePosterorderTravel {

	/**
	 * @param args
	 */
	static TreeNode root = new TreeNode(1);
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nTest = 10;
		Vector test = new Vector(10);
	
		Vector<Boolean> possible = new Vector(nTest);
		
		for(int i=0; i<possible.capacity(); i++) {
			possible.add( new Boolean("false") );
		}

		
		
		List<Integer> result = solution.postorderTraversal(root);
		System.out.print(result.get(0));
		
		
		
	}

}
