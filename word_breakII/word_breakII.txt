public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int nS = s.length();
		
		boolean[] possible = new boolean[nS];
		
		nS ++;
		
		for(int i=0; i<nS; i++) {
			possible[i] = false;
		}
		
		List<List<String>> words = new ArrayList<List<String>>();
		for (int i = 0; i <nS; i++)  {
			words.add(new ArrayList<String>());  
		}
		
		words.get(0).add("");  
		
		possible[0] = true;
		
		
		for(int i =1; i<nS; i++) {
		
			String temp = s.substring(0,i+1);
			
			for(int j=0; j<i; j++) {
				if( possible[j] & dict.contains( s.substring(j,i) ) ) {
					possible[i]= true;
					
					for (String str : words.get(j)) {  
						if (str.equals(""))  
							words.get(i).add(String.format("%s", temp));  
						else  
							words.get(i).add(String.format("%s %s", str, temp));  
					}
				}
			}

		}
		
		return words.get(nS-1);  
		
    }
}