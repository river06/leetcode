package stock;

public class Solution {
	public static int maxProfit(int[] prices) {
		
		if( prices.length == 0) return 0;
		
		// sort from left to right, store the minimum
		
		int min_price = prices[0];
		int max_diff = 0;
		
		for( int i=0; i<prices.length; i++) {
			if(prices[i] - min_price > max_diff) {
				max_diff = prices[i] - min_price;
			}
			
			if(prices[i] - min_price < 0) {
				min_price = prices[i];
			}
		}
		
		
        return max_diff;
    }
}
