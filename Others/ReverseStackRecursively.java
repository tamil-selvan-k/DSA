class Solution {
    private void push(Stack<Integer> st, int num) {
        if(st.isEmpty()) {
            st.add(num);
            return;
        }

        int top = st.pop();
        push(st, num);
        st.add(top);
    }

    public void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }

        int top = st.pop();

        reverseStack(st);

        push(st, top);
    }
}
