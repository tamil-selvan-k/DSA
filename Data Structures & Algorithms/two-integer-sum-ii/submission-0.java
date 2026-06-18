class Solution {
    public int[] twoSum(int[] nums, int target) {
        int lt = 0, rt = nums.length-1;
        int[] res = new int[2];
        while(lt < rt) {
            int sum = nums[lt] + nums[rt];
            if(sum == target) {
                res[0] = lt+1; res[1] = rt+1;
                break;
            } else if(sum > target) {
                rt--;
            } else {
                lt++;
            }
        }

        return res;
    }
}
