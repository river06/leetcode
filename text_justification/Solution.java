import java.util.*;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        int num_word = words.length;

		int p1 = 0;
		int cur_len = 0;

		char[] empty_char = new char[L];
		Arrays.fill(empty_char,' ');
		String empty_str = new String(empty_char);
		ArrayList<String> ret = new ArrayList<String>();
		
		for(int p2=0; p2<num_word; p2++) {
			if( p2 == p1) {
				cur_len = words[p2].length(); // at least one word
			} else if( cur_len + 1 + words[p2].length() > L) {
				String s = lineJustify(words, L, empty_str, p1, p2, cur_len);
				ret.add(s);

				p1 = p2;
				cur_len = 0;
				p2 --;
			} else {
				// add more to the current length
				cur_len += (1 + words[p2].length() );
			}
		}

		// last line
		cur_len = words[p1].length();
		String s = new String(words[p1]);
		for(int i=p1+1; i<num_word; i++) {
			s += ' ';
			s += words[i];
			cur_len += (1+words[i].length() );
		}
		s += empty_str.substring(0, L-cur_len);
		ret.add(s);

		return ret;
		
    }

	public String lineJustify(String[] words, int L, String empty_str, int p1, int p2, int cur_len) {
		int n_gap = p2-1-p1;
		
		if(n_gap == 0) {
			// only one word is added to the current line
			String s = new String(words[p1]);
			s += empty_str.substring(0, L-cur_len);
			return s;
		}

		// calculate num of white space for each gap
		int n_left = L-cur_len;
		int n_space = n_left/n_gap + 1;
		int n_plus = n_left%n_gap;

		String s = new String(words[p1]);
		for(int i=0; i<n_gap; i++) {
			if( i<n_plus ) {
				s += empty_str.substring(0, n_space+1);
			} else {
				s += empty_str.substring(0, n_space);
			}
			s += words[i+1+p1];
		}
		return s;
	}
}