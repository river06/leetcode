public class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length==0) return 0;
        int left = 0;
        int right = height.length-1;
        
        int maxWater = 0;
        
        while(left<right) {
            int tmp = (right-left)*Math.min(height[left],height[right]);
            maxWater = Math.max(maxWater, tmp);
            
            if(height[left]<=height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}