public class Solution {
    public static int findMin(int[] num) {
        if(num == null || num.length ==0) return 0;

		int l = 0;
		int r = num.length-1;
		int result = num[0];



		while(l<r-1) {
			int m = (l+r)/2;
			
			if(num[l]<num[m]) {
				result = Math.min(result, num[l]);
				l = m+1;
			}else if(num[l]>num[m]){
				result = Math.min(result, num[m]);
				r = m-1;
			}else{
				l++;
			}
		}

		result = Math.min(num[l], result);
		result = Math.min(num[r], result);
		
		return result;
		
    }
}
