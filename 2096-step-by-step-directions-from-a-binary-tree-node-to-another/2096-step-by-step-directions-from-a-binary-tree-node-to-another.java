/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lcs=lcs(root,startValue,destValue);
        // System.out.println(lcs.val);
        StringBuilder s=new StringBuilder("");
        StringBuilder r=new StringBuilder("");
        findPath(lcs,s,startValue);
        findPath(lcs,r,destValue);
        // System.out.println(s.toString()+" "+r.toString());
        StringBuilder ans=new StringBuilder("");
        int len=s.length();
        while(len-->0)
            ans.append("U");
        return ans.append(r.reverse().toString()).toString();
        
        //return "";
    }
    boolean findPath(TreeNode root,StringBuilder sb,int s){
        if(root.val==s)
            return true;
        if(root.left!=null && findPath(root.left,sb,s))
            sb.append("L");

        else if(root.right!=null && findPath(root.right,sb,s))
            sb.append("R");
        return sb.length()>0;
    }

    public TreeNode lcs(TreeNode root,int p,int q)
    {
        if(root==null)return null;
        if(root.val==p||root.val==q)
            return root;
        TreeNode l=lcs(root.left,p,q);
        TreeNode r=lcs(root.right,p,q);
       if(l!=null && r!=null)
           return root;
        if(l!=null && r==null)
            return l;
        if(l==null && r!=null)return r;
        return null;
        
    }
}