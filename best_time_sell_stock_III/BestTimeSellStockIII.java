public class Solution {
	public int maxProfit(int[] prices) {
		
		if( prices.length == 0) return 0;
		
		// sweep from left to right, store the max profit at each time
		
		int min_price = prices[0];
		int max_diff = 0;
		int[] max_profit_forward = new int[prices.length]; 
		
		for( int i=0; i<prices.length; i++) {
			if(prices[i] - min_price > max_diff) {
				max_diff = prices[i] - min_price;
			}
			
			if(prices[i] - min_price < 0) {
				min_price = prices[i];
			}
			
			max_profit_forward[i] = max_diff;
		}
		
		// sweep backward, store the max profit at each time (one transaction)
		int max_price = prices[prices.length-1];
		max_diff = 0;
		int[] max_profit_backward = new int[prices.length];
		
		for( int i=prices.length-1; i>=0; i--) {
			if(max_price - prices[i] > max_diff) {
				max_diff = max_price - prices[i];
			}
			
			if(max_price - prices[i] < 0) {
				max_price = prices[i];
			}
			
			max_profit_backward[i] = max_diff;
		}
		
		max_diff = 0;
		for( int i=0; i<prices.length; i++) {
			if( max_profit_forward[i] + max_profit_backward[i] > max_diff ) {
				max_diff = max_profit_forward[i] + max_profit_backward[i];
			}
		}
        return max_diff;
    }
}