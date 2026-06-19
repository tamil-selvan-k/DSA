class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for(int num:nums) set.add(num);
        
        for(int num:set) {
            int curr = 1;
            if(!set.contains(num - 1)) {
                while(set.contains(++num)) {
                    curr++;
                }
                maxLen = Math.max(maxLen, curr);
            }
        }

        return maxLen;
    }
}
