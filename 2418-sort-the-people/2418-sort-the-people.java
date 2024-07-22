class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Data> l=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            l.add(new Data(names[i],heights[i]));
        }
        Collections.sort(l,new Comparator<>(){
            @Override
            public int compare(Data d1,Data d2){
                return d2.height-d1.height;
            }
        });
        String[] str=new String[names.length];
        for(int i=0;i<l.size();i++)
            str[i]=l.get(i).name;
        return str;
    }
    class Data{
        String name;
        int height;
        public Data(String name,int height){
            this.name=name;
            this.height=height;
        }
    }
}