class Solution {
    // Set<List<Integer>> res;
    private void getPowerSet(int[] nums, Set<List<Integer>> res, List<Integer> curr, int ind) {
        res.add(new ArrayList<>(curr));
        if(ind == nums.length) {
            return;
        }

        getPowerSet(nums, res, curr, ind + 1);
        curr.add(nums[ind]);
        getPowerSet(nums, res, curr, ind + 1);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> powerSet(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        getPowerSet(nums, res, new ArrayList<>(), 0);

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> li:res) {
            ans.add(new ArrayList<>(li));
        }

        return ans;
    }
}
