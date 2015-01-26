// Analysis:
// At the first glance, we might think this is a DFS problem, but if we see it is hard to find a quick DFS thought and the problem requires some optimal result (here is the minimum), DP is a good direction to consider.
// Actually this is a classic DP problem:
// The state is:   table[i][j]=minimum number steps convert word1[1:i] to word2[1:j] (here assume string starts from 1).

// The optimal function is:  table[i+1][j+1] = min [table[i][j]+1 or 0 (+0 if word1[i+1]==word2[j+1], else +1),   table[i][j+1]+1, table[i+1][j]+1 ].

// Initialization:
// table[0][i] = i  i=1:|word1|          here 0 means "", any string convert to "" needs the length of string
// table[j][0] = j  i=1:|word2|
// table[0][0]=0    "" convert to  "" need 0 steps.

public class Solution {
    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
		int length2 = word2.length();
		if(length1==0) return length2;
		if(length2==0) return length1;

		int[][] disTable = new int[length1+1][length2+1];
		disTable[0][0]=0;
		for(int i=1;i<=length2;i++) {
			disTable[0][i] = i;
		}
		for(int i=1;i<=length1;i++) {
			disTable[i][0] = i;
		}

		for(int i=1;i<=length1;i++) {
			for(int j=1; j<=length2; j++) {
				int tmp = Math.min(disTable[i-1][j]+1, disTable[i][j-1]+1);
				if(word1.charAt(i-1)!= word2.charAt(j-1)) {
					disTable[i][j] = Math.min( tmp, disTable[i-1][j-1]+1);
				} else {
					disTable[i][j] = Math.min( tmp, disTable[i-1][j-1]);
				}
			}
		}
		return disTable[length1][length2];
		
    }
}