class Solution {
    List<List<Integer>> res;

    private void generate(int[] nums, int idx, List<Integer> arr, int target, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(arr)); return;
        }
        if(idx == nums.length) {
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            if(sum + nums[i] <= target) {
                arr.add(nums[i]);
                generate(nums, i, arr, target, sum + nums[i]);
                arr.remove(arr.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), target, 0);
        return res;
    }
}
