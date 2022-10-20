// https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinimumCostClimbingStairs {

    public static int climbStairs(int[] cost, int currStep, int[] dp){
        if(currStep == 0) return cost[0];
        if(currStep == 1) return cost[1];
        
        if(dp[currStep] != -1) return dp[currStep];
        
        int ans = cost[currStep] + Math.min(climbStairs(cost, currStep-2, dp), climbStairs(cost, currStep-1, dp));
        dp[currStep] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int cost[] = { 10, 15, 20 };

        int dp[] = new int[cost.length];
        
        for(int i=0 ; i<dp.length ; i++){
            dp[i] = -1;
        }
        int ans = Math.min(climbStairs(cost, cost.length-1, dp), climbStairs(cost, cost.length-2, dp));
        System.out.println(ans);
    }
}
