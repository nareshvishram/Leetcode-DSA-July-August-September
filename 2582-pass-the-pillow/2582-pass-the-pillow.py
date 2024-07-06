class Solution(object):
    def passThePillow(self, n, time):
        """
        :type n: int
        :type time: int
        :rtype: int
        """
        if n>time:
            return time+1
        remaining=time%(n-1)
        if ((time//(n-1))%2)==0:
            return remaining+1
        return n-remaining
        