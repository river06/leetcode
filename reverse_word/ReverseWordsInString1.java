public class Solution{
	public String reverseWords(String s) {
		s = s.trim();
		String[] tokensVal = s.split(" +");
		StringBuilder sb = new StringBuilder();

		for( int i=tokensVal.length-1; i>=0; i--){
			if(sb.length()!=0){
				sb.append(" ");
			}
			sb.append(tokensVal[i]);
		}
		String s_solution = sb.toString();
		return s_solution;
	}
}
