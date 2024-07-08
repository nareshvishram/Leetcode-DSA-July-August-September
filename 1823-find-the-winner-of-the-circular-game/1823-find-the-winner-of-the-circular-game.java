class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        // System.out.println(queue);
        // System.out.println("------");
        while(queue.size()>1){
            int delete = k-1;
            System.out.println(queue);
            while(delete>0){
                queue.add(queue.remove());
                delete--;
            }
            // System.out.println(queue);
            
            queue.remove();
        }
        
        return queue.remove();
    }
}