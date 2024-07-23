class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums)
            map.put(x,map.getOrDefault(x,0)+1);
        List<Data> l=new ArrayList<>();
        for(int x:nums)
            l.add(new Data(x,map.get(x)));
        Collections.sort(l,new Comparator<>(){
            @Override
            public int compare(Data d1,Data d2){
                if(d1.freq==d2.freq)
                    return d2.data-d1.data;
                else
                    return d1.freq-d2.freq;
            }
        });
        for(int i=0;i<l.size();i++){
            nums[i]=l.get(i).data;
        }
        return nums;
        
    }
    class Data{
        int data;
        int freq;
        Data(int data,int freq){
            this.data=data;
            this.freq=freq;
        }
    }
}