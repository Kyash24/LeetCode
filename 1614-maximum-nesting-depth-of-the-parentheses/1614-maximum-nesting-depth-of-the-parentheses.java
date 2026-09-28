class Solution {
    public int maxDepth(String s) {
        int max=0,sum=0;
        for(char c:s.toCharArray()){
            if(c=='(')sum++;
            else if(c==')')sum--;
            if(max<sum)max=sum;
        }
        return max;
    }
}