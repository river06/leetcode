import java.util.*;

public class Solution {
    public static int largestRectangleArea(int[] height) {
        // this is a O(n) solution
        // the idea is to store the heights smaller than the current
        // height in a data structure (stack)
        // the right edge is the current bar
        if(height == null || height.length ==0) return 0;
        Stack<Integer> stack_idx = new Stack<Integer>();
        
        // extend the current array to include a dummy height at the end
        int[] height_exd = new int[height.length+1];
        for(int i=0;i<height.length; i++) height_exd[i] = height[i];
        height_exd[height.length] = 0;
        
        int result = 0;
        
        for(int i=0; i<height.length+1; i++) {
            if(stack_idx.empty()) {
                stack_idx.push(i);
            } else if ( height_exd[stack_idx.peek()] <= height_exd[i]) {
                stack_idx.push(i);
            } else {
                while( !stack_idx.empty() && height_exd[stack_idx.peek()] > height_exd[i] ) {
                    int tmp_height = height[stack_idx.pop()];
                    int left_idx = -1;
                    if(!stack_idx.empty()) left_idx = stack_idx.peek();
                    int tmp_area = tmp_height*(i-1-left_idx);
                    if(tmp_area>result) {
                        result = tmp_area;
                        //System.out.println(result);
                    }
                }
                stack_idx.push(i);
            }
        }
        return result;
    }
}