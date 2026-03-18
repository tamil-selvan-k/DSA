class Solution {
    private List<String> res;
    private void generate(int n, String sb) {
        int len = sb.length();
        if(len > 1) {
            if(sb.charAt(len - 1) == sb.charAt(len - 2) && sb.charAt(len - 1) == '1') return;
        }
        if(len == n) {
            res.add(sb);
            return;
        } 

        generate(n, sb + "0");
        generate(n, sb + "1");
    }

    public List<String> generateBinaryStrings(int n) {
        res = new ArrayList<>();
        generate(n, "");

        return res;
    }
}
