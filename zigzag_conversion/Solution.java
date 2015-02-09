public class Solution {
    public String convert(String s, int nRows) {
		if(nRows == 1) return s;
		
		StringBuilder[] new_str = new StringBuilder[nRows];
		for(int i=0; i<nRows; i++) {
			new_str[i] = new StringBuilder();
		}

		for(int i=0; i<s.length(); i++) {

//			int idx0 = i/(2*nRows-2) *(2* nRows-2);

//			int idx1 = i-idx0;

			int idx1 = i%(2*nRows-2);
			if( idx1 >= nRows ) {
				idx1 = 2*nRows -2 - idx1;
			}


			new_str[idx1].append( s.charAt(i) );
		}
		String ret = new String();
		for(int i=0; i<nRows; i++) {
			ret += new_str[i].toString();
		}
		
		return ret;
			
    }
}