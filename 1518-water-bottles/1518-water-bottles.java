class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink=numBottles;
        while(true){
            int remg=numBottles%numExchange;
            int exchange=numBottles/numExchange;
            if(exchange==0)
                return drink;
            drink+=exchange;
            numBottles=remg+exchange;
        }
    }
}