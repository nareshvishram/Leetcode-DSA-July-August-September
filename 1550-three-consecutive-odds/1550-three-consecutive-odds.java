class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if((arr[i]&1)!=0){
                int cnt=1;
                while(++i<arr.length && (arr[i]&1)!=0)
                    cnt++;
                if(cnt>=3)
                    return true;
            }
        }
        return false;
    }
}