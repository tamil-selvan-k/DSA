class Solution {
    List<List<Integer>> res;
    private void getCombs(int n, int k, int sum, int len, int ind, List<Integer> arr) {
        if(sum == n && len == k) {
            res.add(new ArrayList<>(arr));
            return;
        } else if(sum > n || len > k) return;

        for(int i=ind;i<=9;i++) {
            if(sum + i <= n) {
                arr.add(i);
                getCombs(n, k, sum + i, len + 1, i + 1, arr);
                arr.remove(arr.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        getCombs(n, k, 0, 0, 1, new ArrayList<>());

        return res;
    }
}
