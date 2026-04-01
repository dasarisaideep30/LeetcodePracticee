class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int x:asteroids){
            while(!st.isEmpty() && x<0 && st.peek()>0){
                if(st.peek()<-x){
                    st.pop();
                }
                else if(st.peek()==-x){
                    st.pop();
                    x=0;
                }
                else{
                    x=0;
                }
            }
            if(x!=0){
                st.push(x);
            }
        }
        int[] res = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
}