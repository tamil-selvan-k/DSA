class Solution {
    public int findDuplicate(int[] nums) {
        int[] idx = new int[10001];
        for(int num:nums) {
            if(idx[num] == 1) 
                return num;
            idx[num] = 1;
        }

        return -1;
    }
}
