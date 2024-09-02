class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0l;
        for(int i=0;i<chalk.length;i++)
            sum+=chalk[i];
        long x=(k%sum);
        k=(int)x;
        if(k==0)
            return 0;
        int i=0;
        while(i<chalk.length && k>=chalk[i]){
            k-=chalk[i];
            i++;
        }
        return i;
    }
}