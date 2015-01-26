/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int maxNumTotal = 0;
        
        // note the trick of not iterating all the way 
        // until the end
        // notice length instead of length()
        for(int i=0; i< points.length-maxNumTotal; i++){
            // construct a map to store the mapping
            // Map<K,V>: Map of Key and Value
            // Map is an public interface
            HashMap<Double,Integer> slopeMap = new HashMap<Double, Integer>();
            
            // number of points the same as the start point
            // this code does not consider collisions between other points
            int numCollideStart = 0;
			
			int maxNumMap = 0;
			
            Double slope;
            for(int j=i+1; j<points.length; j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        numCollideStart ++;
                        continue;
                    }else{
                        slope = Double.POSITIVE_INFINITY;
                    }
                }else if(points[i].y == points[j].y){
					slope = new Double(0); // positive and negative zero does matter
				}else{
                    slope = new Double( (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x));
                }
                // increase the value associated with Key slope by one
                if(slopeMap.containsKey(slope)){
                    Integer tmp = slopeMap.get(slope)+1;
                    slopeMap.put(slope, tmp);
					if(tmp > maxNumMap){
						maxNumMap = tmp;
					}
                }else{
                    slopeMap.put(slope, new Integer(1));
					if(1 > maxNumMap){
						maxNumMap = 1;
					}
                }
            }
            // find the maximum number of points on the same line for 
			
			maxNumTotal = Math.max(maxNumTotal, 1+numCollideStart+maxNumMap);
        }
		return maxNumTotal;
    }
}