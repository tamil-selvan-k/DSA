class Solution {
    int count = 0;
    private void getSubs(int[] nums, int sum, int ind) {
        if(sum == 0) {
            count++;
            return;
        } else if(ind == nums.length) {
            return;
        } 
        if(sum < 0) return;

        getSubs(nums, sum - nums[ind], ind + 1);
        getSubs(nums, sum, ind + 1);
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        getSubs(nums, k, 0);
        return count;
    }
}
