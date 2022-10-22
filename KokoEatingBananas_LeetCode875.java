// https://leetcode.com/problems/koko-eating-bananas/

public class KokoEatingBananas_LeetCode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1, n = piles.length, i;
        
        for(i=0;i<n;i++){
            if(max < piles[i]){
                max = piles[i];
            }
        }
        
        int low = 1, high = max, bananaEatRate, hrsTaken;
        
        while(low<=high){
            bananaEatRate = low + (high-low)/2;      // different name for mid
            hrsTaken = 0;
            
            for(i=0 ; i<n ; i++){
                hrsTaken += Math.ceil(piles[i]/(double)bananaEatRate);
                if(hrsTaken > h) break;
            }
            
            if(hrsTaken > h){
                low = bananaEatRate + 1;
            }
            else{
                high = bananaEatRate - 1;
            }
        }
        
        return low;
    }
}
