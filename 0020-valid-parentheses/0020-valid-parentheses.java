class Solution {
     public boolean isValid(String s) {
         Stack<Character> st = new Stack<>();
          for (int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i);
             if (c == '(' || c == '{' || c == '[') {
                 st.push(c);
                  } 
            else if (st.isEmpty()) {
                 return false; 
                 }
             else { char top = st.pop();
             if (c == ')' && top != '(') return false;
             if (c == '}' && top != '{') return false;
             if (c == ']' && top != '[') return false;
              } 
              } 
         return st.isEmpty(); 
    }
}