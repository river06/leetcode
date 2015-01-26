public class Solution {
    public static boolean canJump(int[] A) {
        if(A==null || A.length==0) return false;
        // use three pointers to navigate
        int pHead = 0;
        int pTail = 0;
        int pIter = 0;
        int pTailNext = 0;
        //boolean ifJump = false;
        while(pHead<=pTail) {
            for(pIter = pHead; pIter<=pTail; pIter++) {
                int tmp = pIter + A[pIter];
                if(tmp>pTailNext) pTailNext = tmp;
                if(pTailNext >= A.length-1) {
                    //ifJump = true;
                    //break;
                    return true;
                }
            }
            pHead = pTail+1;
            pTail = pTailNext;
        }
        
        return false;
    }
}