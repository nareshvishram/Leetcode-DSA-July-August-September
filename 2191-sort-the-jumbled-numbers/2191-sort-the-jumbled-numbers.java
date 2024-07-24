class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<mapping.length;i++)
            map.put(i,mapping[i]);
        List<Data> l=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            int newNum=0,j=1;
            if(curr==0)
                newNum=map.get(0);
            while(curr!=0){
                newNum+=(map.get(curr%10))*(j);
                curr/=10;
                j*=10;
            }
            
            l.add(new Data(newNum,i,nums[i]));
        }
        // System.out.println(l);
        Collections.sort(l,new Comparator<>(){
            @Override
            public int compare(Data d1,Data d2){
                if(d1.d==d2.d)
                    return d1.i-d2.i;
                return d1.d-d2.d;
            }
        });
        for(int i=0;i<l.size();i++)
            nums[i]=l.get(i).org;
        return nums;
    }
    class Data{
        int d;
        int i;
        int org;
        Data(int d,int i,int org){
            this.d=d;
            this.i=i;
            this.org=org;
        }
        @Override
        public String toString(){
            return this.d+"-->"+this.i+"-->"+this.org;
        }
    }
}