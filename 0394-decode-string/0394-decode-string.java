class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();

        int n = 0;
        String res="";

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                n=n*10+(c-'0');
            }
            else if(c=='['){
                num.push(n);
                str.push(res);
                n=0;
                res="";
            }
            else if(c==']'){
                int k = num.pop();
                String temp = str.pop();
                String t = "";
                for(int i=0;i<k;i++){
                    t+=res;
                }
                res = temp + t;
            }
            else{
                res+=c;
            }
        }
        return res;
    }
}