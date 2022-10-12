public class BestTimeToBuyAndSellStock_LeetCode {
    public static void main(String[] args) {
        int profit = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0, current, lowest_buy=Integer.MAX_VALUE, profit_if_sold;
        
        for(int i=0;i<prices.length;i++){
            current = prices[i];
            
            if(current < lowest_buy){
                lowest_buy = current;
            }
            
            profit_if_sold = current - lowest_buy;
            
            if(profit_if_sold > profit){
                profit = profit_if_sold;
            }
        }
        
        return profit;
    }
}