class Solution {
    public int numTeams(int[] rating) {
        int count=0,i=0,j=1,k=2,n=rating.length;
        if(n<3)
            return 0;
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                for(k=j+1;k<n;k++){
                    if(rating[i]>rating[j] && rating[j]>rating[k])
                        count++;
                    if(rating[i]<rating[j] && rating[j]<rating[k])
                        count++;
                }
            }
        }
        return count;
    }
}