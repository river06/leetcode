public class Solution {
    public static String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		char[] roman = {'I','V','X','L','C','D','M','d'};
		int base = 10;
		while(num >0) {
			int i = 0;
			while( num/ myPow(base,i) > 9){
				i ++;
			}

			int bit = num/myPow(base,i);

			foo(i, bit, roman, result);

			num -= bit * myPow(base,i);

			//System.out.println(i);
		}

		return result.toString();
    }

	private static int myPow(int a, int b) {
		int result = 1;
		for(int i=0; i<b; i++) result *= a;
		return result;
	}

	private static void foo(int pos, int digit, char[] roman, StringBuilder result) {
		
		switch(digit) {

		case 1:
			result.append(roman[pos*2]);
			break;
		case 2:
			result.append(roman[pos*2]);
			result.append(roman[pos*2]);
			break;
		case 3:
			result.append(roman[pos*2]);
			result.append(roman[pos*2]);
			result.append(roman[pos*2]);
			break;
		case 4:
			result.append(roman[pos*2]);
			result.append(roman[pos*2 + 1]);
			break;
		case 5:
			result.append(roman[pos*2+1]);
			break;
		case 6:
			result.append(roman[pos*2+1]);
			result.append(roman[pos*2]);
			break;
		case 7:
			result.append(roman[pos*2+1]);
			result.append(roman[pos*2]);
			result.append(roman[pos*2]);
			break;
		case 8:
			result.append(roman[pos*2+1]);
			result.append(roman[pos*2]);
			result.append(roman[pos*2]);
			result.append(roman[pos*2]);
			break;
		case 9:
			result.append(roman[pos*2]);
			result.append(roman[pos*2+2]);
		default:
			break;
		}
	}
}