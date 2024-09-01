class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int res[][]=new int[m][n];
        int n1=original.length;
        if(m*n!=n1)
            return new int[0][0];
        for(int i=0;i<n1;i++)
            res[i/n][i%n]=original[i];
        return res;
    }
}