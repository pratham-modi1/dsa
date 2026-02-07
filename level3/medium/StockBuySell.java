//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class StockBuySell {

    public static void main(String[] args) {
        int[] prices = {5,2,4,1}; 

        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];  
        int profit = 0;
        int maxprofit = 0;
        
        
        
        
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min ){
                min = prices[i];
                
            }
            
            if(prices[i]>min){
                    profit=prices[i]-min;
            }

        if(profit>maxprofit){
                    maxprofit=profit;
                }

            }
            
            
        
        





        return maxprofit ;
    }

}