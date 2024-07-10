class Solution(object):
    def minOperations(self, logs):
        """
        :type logs: List[str]
        :rtype: int
        """
        count=0
        for i in range(len(logs)):
            if '../' in logs[i]:
                count-=1
            elif './' in logs[i]:
                continue
            else:
                count+=1
            if count<0:
                count=0
        return count
        