import java.util.*;

public class Solution {
    public int[] plusOne(int[] digits) {
        // corner case: overflow
		boolean flag_overflow = true;
		for(int i=0; i<digits.length; i++) {
			if(digits[i] != 9) {
				flag_overflow = false;
				break;
			}
		}

		int[] result;
		if(flag_overflow) {
			result = new int[digits.length + 1];
			Arrays.fill(result, 0);
			result[0] = 1;
		} else {
			for(int i=digits.length -1; i>=0; i--) {
				digits[i] += 1;
				
				if(digits[i] >= 10) {
					digits[i] = 0;
				} else {
					break;
				}
			}
			result = digits;
		}

		return result;
    }
}