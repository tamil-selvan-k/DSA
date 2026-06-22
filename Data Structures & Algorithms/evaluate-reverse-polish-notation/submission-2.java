class Solution {
    private int opr(char opr, int num2, int num1) {
        int res = 0;
        switch(opr) {
            case '+': res = num1 + num2; break;
            case '-': res = num1 - num2; break;
            case '*': res = num1 * num2; break;
            case '/': res = num1 / num2; break;
        }

        return res;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token:tokens) {
            if(Character.isDigit(token.charAt(token.length() - 1)))
                st.push(Integer.parseInt(token));
            else {
                if(st.size() >= 2) {
                    int num1 = st.pop();
                    int num2 = st.pop();
                    st.push(opr(token.trim().charAt(0), num1, num2));
                }
            }
        }

        return st.peek();
    }
}