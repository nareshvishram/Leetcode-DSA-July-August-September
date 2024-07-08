class Solution(object):
    def findTheWinner(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        l=[i for i in range(1,n+1)]
        while len(l)>1:
            remove=k-1
            while remove>0:
                l.append(l.pop(0))
                remove-=1
            l.pop(0)
        return l.pop(0)
        