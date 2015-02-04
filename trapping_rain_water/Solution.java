import java.util.*;

public class Solution {
    public int trap(int[] A) {
        int result = 0;
		// append an zero height bar to the end of A to
		// deal with corner cases ??
		int len = A.length;
		if(len < 2) return 0;

		// use a stack to store the indices of bars that are
		// taller than the current bar
		Stack<Integer> idx_stack = new Stack<Integer>();

		int i = 0;
		
		while( i<len ) {
			if( idx_stack.isEmpty() || A[idx_stack.peek()] > A[i])  {
				idx_stack.push(i);
				i++;
			} else if( idx_stack.size() == 1) {
				idx_stack.pop();
				idx_stack.push(i);
				i++;
			} else {
				int height_mid = A[idx_stack.pop()];
				int idx_pre = idx_stack.peek();
				int height_diff = Math.min(A[i], A[idx_pre]) - height_mid;
				result += height_diff*(i-1-idx_pre);
			}
		}
		return result;
    }
}