class Solution {
    List<List<Integer>> res;
    private void generate(int[] nums, int idx, List<Integer> arr) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[idx]);
        generate(nums, idx + 1, arr);
        arr.remove(arr.size() - 1);
        generate(nums, idx + 1, arr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        generate(nums, 0, new ArrayList<>());
        return res;
    }
}
