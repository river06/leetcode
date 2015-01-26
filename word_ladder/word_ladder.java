public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        
		if(dict.isEmpty()) return 0;
		
		int word_length = start.length();
		
		// double BFS 
		
		Queue<String> start_q = new LinkedList<String>(); // the queue for storing forward BFS
		Queue<String> end_q = new LinkedList<String>(); // for backward BFS
		Queue<Integer> start_dis = new LinkedList<Integer>();
		Queue<Integer> end_dis = new LinkedList<Integer>();
		
		start_q.add(start);
		start_dis.add(0);
		end_q.add(end);
		end_dis.add(0);
		
		while( !start_q.isEmpty() && !end_q.isEmpty() ){
			// forward BFS
	
			int tmp_dis = start_dis.peek();
			while(!start_dis.isEmpty() && tmp_dis == start_dis.peek()) { // search for a level
				String tmp_str = start_q.remove(); // dequeue
				tmp_dis = start_dis.remove();
				for(int i=0; i<word_length; i++) { // for each character
					char[] tmp_char_ary = tmp_str.toCharArray();
					for(char c='a'; c<='z'; c++) {
						if( c != tmp_str.charAt(i) ) {
							tmp_char_ary[i] = c;
							String mdf_str = new String(tmp_char_ary);
							// judge if mdf_str is contained by end_q
							if( end_q.contains( mdf_str ) ){
								// return length
								return tmp_dis + end_dis.peek() + 2;
							} else if(dict.contains(mdf_str)) {
								// add string to queue and remove it form dict
								start_q.add(mdf_str);
								dict.remove(mdf_str);
								// maintain length queue
								start_dis.add( tmp_dis + 1);
							}
						}
					}
				}
			}
			
			// backward BFS
			tmp_dis = end_dis.peek();
			while(!end_dis.isEmpty() && tmp_dis == end_dis.peek()) { // search for a level
				String tmp_str = end_q.remove(); // dequeue
				tmp_dis = end_dis.remove();
				for(int i=0; i<word_length; i++) { // for each character
					char[] tmp_char_ary = tmp_str.toCharArray();
					for(char c='a'; c<='z'; c++) {
						if( c != tmp_str.charAt(i) ) {
							tmp_char_ary[i] = c;
							String mdf_str = new String(tmp_char_ary);
							// judge if mdf_str is contained by end_q
							if( start_q.contains( mdf_str ) ){
								// return length
								return tmp_dis + start_dis.peek() + 2;
							} else if(dict.contains(mdf_str)) {
								// add string to queue and remove it form dict
								end_q.add(mdf_str);
								dict.remove(mdf_str);
								// maintain length queue
								end_dis.add( tmp_dis + 1);
							}
						}
					}
				}
			}
			
		}
		return 0;
    }
}