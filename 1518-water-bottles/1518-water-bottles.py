class Solution(object):
    def numWaterBottles(self, numBottles, numExchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        drink=numBottles
        while True:
            remg=numBottles%numExchange
            exchange=numBottles//numExchange
            if exchange==0:
                return drink
            drink=drink+exchange
            numBottles=remg+exchange
        