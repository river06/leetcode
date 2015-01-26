public class Solution{
	public String reverseWords(String s) {
		int s_length = s.length();
		int mark_start = s_length - 1;
		int mark_end = s_length - 1;
		int s_started = 0;
		String s_solution = "";

		if( s_length > 0)
		{
			for(int i = s_length-1; i>=0 ; i--){
				if( s.charAt(i) != ' ' && s_started == 0){
					mark_end = i;
					s_started = 1;
				}else if( s.charAt(i) == ' ' && s_started == 1){
					mark_start = i+1;
					s_started = 0;
					for(int j=mark_start; j<=mark_end; j++){
						s_solution = s_solution +  s.charAt(j);
					}
					s_solution = s_solution + ' ';
				}
			}
			if(s.charAt(0) != ' ' && s_started == 1){
				// process the last (first) word
				for(int j=0; j<=mark_end; j++){
					s_solution = s_solution +  s.charAt(j);
				}
			}else{
				// remove the tailing space
				s = s.substring(0, s.length() - 1);
			}
		}
		
		return s_solution;
	}
}
