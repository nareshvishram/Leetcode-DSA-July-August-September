class Solution {
    public int passThePillow(int n, int time) {
        if(n>time)
            return time+1;
        int remain=time%(n-1);
        if((time/(n-1)%2)==0)
            return remain+1;
        return n-remain;
    }
}