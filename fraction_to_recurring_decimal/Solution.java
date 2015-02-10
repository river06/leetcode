import java.util.*;
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0) return "";
        if(numerator==0) return "0";
		StringBuilder sb = new StringBuilder();

		boolean if_neg = false;
		if(numerator<0 ^ denominator<0) if_neg = true;

		long numerator_abs = Math.abs( (long) numerator );
		long denominator_abs = Math.abs( (long) denominator );
		long quotient_abs = numerator_abs/denominator_abs;
		long rem = (numerator_abs % denominator_abs);

		if( if_neg ) sb.append("-");
		sb.append( Long.toString(quotient_abs) );

		if( rem == 0) return sb.toString();
		
		sb.append(".");
		Map<Long, Integer> rem_map = new HashMap<Long, Integer>();
		// key: remaining number, value: index in fraction
		int idx = sb.length();
		while(rem > 0) {

			if(!rem_map.isEmpty() && rem_map.containsKey(rem)){ 
				int idx1 = rem_map.get(rem);
				
				String str_in_par = sb.substring(idx1);
				sb.delete(idx1, idx);
				sb.append("(");
				sb.append(str_in_par);
				sb.append(")");
				break;
			} else {
				rem_map.put(rem, idx);
			}
			
			rem *=10;
			long quotient_dec = rem/denominator_abs;
			rem %= denominator_abs;
			sb.append( quotient_dec);
			
			idx++;
		}
		
		return sb.toString();
		
    }
}
