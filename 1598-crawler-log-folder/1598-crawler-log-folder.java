class Solution {
    public int minOperations(String[] logs) {
        int ans=0;
        Stack<String> st=new Stack<>();
        for(String log:logs){
            if(log.equals("../")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(!log.equals("./")){
                st.push(log);
            }
        }
        System.out.println(st);
        return st.size();
    }
}