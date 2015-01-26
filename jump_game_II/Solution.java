public class Solution {
    public static int jump(int[] A) {
        if(A==null || A.length==0) return -1;
        // use three pointers to navigate
        int pHead = 0;
        int pTail = 0;
        int pIter = 0;
        int pTailNext = 0;
        
        int numJump = 0;
        
        if(A.length == 1) return numJump;
        
        while(pHead<=pTail) {
            for(pIter = pHead; pIter<=pTail; pIter++) {
                int tmp = pIter + A[pIter];
                if(tmp>pTailNext) pTailNext = tmp;
                if(pTailNext >= A.length-1) {
                    numJump ++;
                    return numJump;
                }
            }
            numJump ++;
            pHead = pTail+1;
            pTail = pTailNext;
        }
        
        return -1;
    }
}