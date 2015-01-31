public class Solution {
    public int romanToInt(String s) {
        // sweep from left to right
		// if the second integer is larger than the first
		// minus last num
		// else add current number
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			if( i>0 && char2Int(s.charAt(i)) > char2Int(s.charAt(i-1)) ){
				result += char2Int(s.charAt(i))-2*char2Int(s.charAt(i-1));
			} else {
				result += char2Int(s.charAt(i));
			}
		}
		return result;
    }

	public int char2Int(char c) {
		switch(c) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default: return 0;
		}
	}
}