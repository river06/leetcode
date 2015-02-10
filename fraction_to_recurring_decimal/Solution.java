public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0) return "";
		StringBuilder sb = new StringBuilder();

		boolean if_neg = false;
		if(numerator<0 ^ denominator<0) if_neg = true;

		long numerator_abs = Math.abs( (long) numerator );
		long denominator_abs = Math.abs( (long) denominator );
		long quotient_abs = numerator_abs/denominator_abs;
		long rem = numerator_abs % denominator_abs;

		if( if_neg ) sb.append("-");
		sb.append( quotient_abs.toString() );

		if( rem == 0) return sb.toString();

		Map<Integer, Integer> rem_map = new HashMap<Integer, Integer>();
		// key: remaining number, value: index in fraction
		while(rem > 0) {
		}
		
    }
}