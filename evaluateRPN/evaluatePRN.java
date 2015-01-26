public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<String>();
		int result = 0;
		for(int i =0; i<tokens.length; i++){
			String s = tokens[i];
			if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ){
				int num2 = Integer.parseInt( (String) st.pop() );
				int num1 = Integer.parseInt( (String) st.pop() );
				if(s.equals("+")){
					result = num1 + num2;
				}else if(s.equals("-")){
					result = num1 - num2;
				}else if(s.equals("*")){
					result = num1 * num2;
				}else{
					result = num1 / num2;
				}
				st.push( Integer.toString(result) );
			}else{
				st.push( s );
			}
		}
		
		result = Integer.parseInt((String) st.pop());
		return result;
    }
	
}