class Solution {
    private void insert(Stack<Integer> st, int num) {
        if(st.isEmpty() || st.peek() <= num) {
            st.add(num);
            return;
        }

        int top = st.pop();
        insert(st, num);
        st.add(top);
    }

    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }

        int top = st.pop();

        sortStack(st);

        insert(st, top);
    }
}
