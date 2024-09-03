class Solution {
    public int getLucky(String s, int k) {
        
        String tmp="";
        for(int i=0;i<s.length();i++){
            tmp+=s.codePointAt(i)-96;
        }
        return getRes(tmp,k,s);
        
    }
    private int getRes(String tmp,int k,String s){
        if(k==0)
            return Integer.parseInt(tmp);
        int x=0;
        for(int i=0;i<tmp.length();i++){
            x+=tmp.codePointAt(i)-48;
        }
        //s=x+"";
        k--;
        return getRes(x+"",k,s);
    }
}