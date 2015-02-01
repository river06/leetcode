import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
        String[] boom = path.split("/");

		// for(int i=0; i<boom.length; i++) {
		// 	System.out.println(boom[i]);
		// }
		
		Stack<String> path_stack = new Stack<String>();

		// push all path segments into stack
		for(int i=0; i<boom.length; i++) {
			if(boom[i].equals(".") || boom[i].equals("")) continue;
			if(boom[i].equals("..")) {
				if( !path_stack.isEmpty()) path_stack.pop();
				continue;
			}
			path_stack.push( boom[i]);
		}
		String ret = new String();
		for(int i=0; i<path_stack.size(); i++) {
			ret += '/';
			ret += path_stack.get(i);
		}
		if(ret.length()==0) ret = "/";
		return ret;
    }
}