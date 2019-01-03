public class Solution {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        int n = A.length();
        for(int i=0; i<n; i++){
            char c = A.charAt(i);
            if(c == ')'){
                int flag=1;
                char top = stack.pop();
                while(top != '('){
                    if(top=='+' || top=='*' || top=='-' || top=='/'){
                        flag=0;
                    }
                    top = stack.pop();
                }
                if(flag == 1)return 1;
            }
            else{
                stack.push(c);
            }
        }
        return 0;
    }
}
