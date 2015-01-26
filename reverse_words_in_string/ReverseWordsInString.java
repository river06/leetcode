public class Solution{
	public String reverseWords(String s) {
		int s_length = s.length();
		int mark_start = s_length - 1;
		int mark_end = s_length - 1;
		boolean s_started = 0;
		String s_solution;
		for(int i = s_length-1; i>0 ; i--){
			if( s.charAt(i) != ' ' && s_started == 0){
				mark_end = i;
				s_started = 1;
			}else if( s.charAt(i) == ' ' && s_started == 1){
				mark_start = i+1;
				s_started = 0;
				for(int j=mark_start; j<=mark_end; j++){
					s_solution = s_solution.concat( s.charAt(j) );
				}
			}
	}
}
