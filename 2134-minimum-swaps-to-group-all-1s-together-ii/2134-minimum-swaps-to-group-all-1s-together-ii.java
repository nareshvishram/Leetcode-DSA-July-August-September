class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length,ones=0;
        int combine[]=new int[2*n];
        for(int i=0;i<n;i++){
            if(nums[i]==1)
                ones++;
            combine[n+i]=nums[i];
            combine[i]=nums[i];
        }
        //System.out.println(ones);
        int prefix[]=new int[2*n];
        prefix[0]=nums[0]==0?0:1;
        for(int i=1;i<2*n;i++){
            prefix[i]=prefix[i-1]+(combine[i]==0?0:1);
        }
        int max=Integer.MIN_VALUE;
        int count=0;
        //System.out.println(Arrays.toString(prefix));
        for(int i=0;i<2*n;i++){
            if(i>=ones && combine[i-ones]==1)count--;
            if(combine[i]==1)count++;
            max=Math.max(max,count);
        }
        return ones-max;

    }
}