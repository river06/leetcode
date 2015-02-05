import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> par_stack = new Stack<Character>();

		for(int i=0; i<s.length(); i++) {
			if(par_stack.isEmpty() || s.charAt(i) == '(' ||
			   s.charAt(i) == '[' || s.charAt(i) == '{' ) {
				par_stack.push( s.charAt(i) );
			} else {
				char tmp = par_stack.pop();
				switch (s.charAt(i) ){
				case ')':
					if(tmp != '(') return false;
					break;
				case ']':
					if(tmp != '[') return false;
					break;
				case '}':
					if(tmp != '{') return false;
					break;
				default:
					return false;
				}
			
			}
		}
		return par_stack.isEmpty();
    }
}