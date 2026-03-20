class Solution {
    private boolean isExist(int[] nums, int sum, int ind) {
        if(sum == 0) return true;
        if(nums.length == ind || sum < 0) return false;

        if(isExist(nums, sum - nums[ind], ind + 1)) return true;
        if(isExist(nums, sum, ind + 1)) return true;

        return false;
    }

    public boolean checkSubsequenceSum(int[] nums, int k) {
        return isExist(nums, k, 0);
    }
}
