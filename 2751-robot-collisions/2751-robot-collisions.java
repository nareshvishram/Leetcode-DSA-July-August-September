class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans=new ArrayList<>();
        List<Data> l=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<positions.length;i++){
            l.add(new Data(positions[i],healths[i],directions.charAt(i)));
            map.put(positions[i],i);
        }
        Collections.sort(l, (o1, o2) -> o1.pos-o2.pos);
        Stack<Data> st=new Stack<>();

        Arrays.fill(healths,-1);
        ///boolean flag=false;
        for(Data d:l){
            //System.out.println(st);
            if(d.dir=='R')
                st.push(d);
            else{
                while(!st.isEmpty()){
                    Data currHealth=st.pop();
                    if(currHealth.health>d.health) {
                        //st.pop();
                        st.push(new Data(currHealth.pos, currHealth.health - 1, currHealth.dir));
                        break;
                    }
                    else if (currHealth.health==d.health) {
                        d.setHealth(0);
                        break;
                    } else
                        d.setHealth(d.getHealth()-1);
                   // System.out.println("after change"+st);
                    //flag=true;
                }
                if(st.isEmpty() && d.health!=0)
                        healths[map.get(d.pos)]=d.health;
            }
        }
//        if(!flag)
//            return ans;
        // System.out.println(st);
        // System.out.println(ans);
        // System.out.println(Arrays.toString(healths));
        for(Data d:st)
            healths[map.get(d.pos)]=d.health;

        // System.out.println(l);
        for(int x:healths)
            if(x!=-1)
                ans.add(x);
        return ans;
    }

    class Data{
        int pos;
        int health;
        char dir;

        public Data(int pos, int health, char dir) {
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public char getDir() {
            return dir;
        }

        public void setDir(char dir) {
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "pos=" + pos +
                    ", health=" + health +
                    ", dir=" + dir +
                    '}';
        }
    }
}