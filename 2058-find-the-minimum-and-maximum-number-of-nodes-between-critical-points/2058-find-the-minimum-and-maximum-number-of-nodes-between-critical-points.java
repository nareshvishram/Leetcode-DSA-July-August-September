/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> tmp=new ArrayList<>();
        int ans[]=new int[]{-1,-1};
        if(head==null || head.next==null || head.next.next==null)
            return ans;
        ListNode curr=head.next,prev=head,next=head.next.next;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int idx=2;
        while(next!=null){
            if((curr.val<prev.val && curr.val<next.val)|| (curr.val>prev.val && curr.val>next.val))
                tmp.add(idx);
            idx++;
            prev=curr;
            curr=next;
            next=next.next;
        }
        // for(int i=0;i<tmp.size();i++){
        //     for(int j=0;j<tmp.size();j++){
        //         if(i!=j){
        //             max=Math.max(max,Math.abs(tmp.get(i)-tmp.get(j)));
        //             min=Math.min(min,Math.abs(tmp.get(i)-tmp.get(j)));
        //         }
        //     }
        // }
        if(tmp.size()>=2)
            max=tmp.get(tmp.size()-1)-tmp.get(0);
        for(int i=0;i<tmp.size()-1;i++){
            min=Math.min(min,tmp.get(i+1)-tmp.get(i));
        }
        if(min!=Integer.MAX_VALUE && max!=Integer.MIN_VALUE){
            ans[0]=min;
            ans[1]=max;
        }
        
        //System.out.println(tmp);
        return ans;
    }
}