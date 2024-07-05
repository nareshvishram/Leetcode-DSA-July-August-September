# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def nodesBetweenCriticalPoints(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: List[int]
        """
        l,ans,idx=[],[-1,-1],2
        if not head or not head.next or not head.next.next:
            return ans

        curr,prev,next_=head.next,head,head.next.next

        while next_:
            if (curr.val>prev.val and curr.val>next_.val) or (curr.val<prev.val and curr.val<next_.val):
                l.append(idx)
            idx=idx+1
            prev=curr
            curr=next_
            next_=next_.next
        
        max,min=-1,pow(10,6)
        # print(l)
        if len(l)>=2:
            max=l[-1]-l[0]
        for i in range(len(l)-1):
            if min>(l[i+1]-l[i]):
                min=l[i+1]-l[i]
        if max!=-1 and min!=pow(10,6):
            ans[0]=min
            ans[1]=max

        return ans
