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
    public ListNode mergeNodes(ListNode head) {
        ListNode ansRoot=null,tmpPtr=null;
        if(head==null)
            return ansRoot;
        while(head!=null){
            head=head.next;
            if(head!=null){
                int cnt=0;
                while(head.val!=0 && head.next!=null){
                    cnt+=head.val;
                    head=head.next;
                }
                if(ansRoot==null){
                    ansRoot=new ListNode(cnt);
                    tmpPtr=ansRoot;
                }
                else{
                    tmpPtr.next=new ListNode(cnt);
                    tmpPtr=tmpPtr.next;
                }
            }
        }
        return ansRoot;
    }
}