class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st =new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("C")){
                st.pop();
            }
            else if(operations[i].equals("D")){
                st.push(2*st.peek());
            }
            else if(operations[i].equals("+")){
                int n1=st.pop();
                int n2=st.peek();
                st.push(n1);
                st.push(n1+n2);           
            }
            else{
                int n=Integer.parseInt(operations[i]);
                st.push(n);
            }
        }
        int sum=0;
        while(!st.isEmpty()){
           sum+=st.pop();
        }
        return sum;
    }
}