class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer,Integer> map1=new HashMap<>();
    Map<Integer,Integer> map2=new HashMap<>();

    for(int x:nums1)
        map1.put(x,map1.getOrDefault(x,0)+1);
    for(int x:nums2)
        map2.put(x,map2.getOrDefault(x,0)+1);
    
    List<Integer> l=new ArrayList<>();
    for(int x:nums1){
        if(map2.containsKey(x)){
            int cnt1=map2.get(x);
            int cnt2=map1.get(x);
            while(cnt1-->0 && cnt2-->0){
                l.add(x);
            }
            map2.put(x,0);
        }
    }
    System.out.println(l);
    int arr[]=new int[l.size()];
    int idx=0;
    for(int x:l)
        arr[idx++]=x;
    return arr;
    }
}