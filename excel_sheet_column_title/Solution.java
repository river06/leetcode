public class Solution {
    public String convertToTitle(int n) {
		StringBuilder ret = new StringBuilder();
        if(n<=0) return ret.toString();

		int radix = 26;
		while(n>0) {
			int digit = n%radix;
			if(digit == 0) digit = radix;
			char c = (char)( (int)'A' + digit-1 );
			ret.insert(0, c);
			n-=digit;
			n/=radix;
		}
		return ret.toString();
    }
}