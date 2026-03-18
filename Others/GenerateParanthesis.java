class Solution {
    List<String> res;
    private void generate(String s, int left, int right, int n) {
        if(left == n && right == n) {
            res.add(s);
            return;
        }

        if(left < n)
            generate(s + "(", left + 1, right, n);
        if(right < n && left > right)
            generate(s + ")", left, right + 1, n);
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate("", 0, 0, n);

        return res;
    }
}
