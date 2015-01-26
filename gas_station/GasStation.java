public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int nStation = gas.length;
		int netGas = 0;
		int indexGas = -1;
		int minGas = Integer.MAX_VALUE;
		
		for(int i=0; i<nStation; i++) {
			netGas += gas[i] - cost[i];
			if(netGas < minGas) {
				minGas = netGas;
				indexGas = i+1;
			}
		}
		
		if(netGas < 0) {
			return -1;
		} else {
			return indexGas % nStation;
		}
    }
}