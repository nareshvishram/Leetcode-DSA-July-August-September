class Solution {
    public double averageWaitingTime(int[][] customers) {
        int availableAt = 0;
        double totalWait = 0;
        for (int[] customer : customers) {
            int arrival = customer[0];
            int timeToPreapreOrder = customer[1];
            availableAt = Math.max(availableAt, arrival) + timeToPreapreOrder;
            totalWait += availableAt - arrival;
        }
        return totalWait / customers.length;
    }
}