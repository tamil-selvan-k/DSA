class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCnt = 0;
        for(int num:nums) {
            int n = num;
            int currCnt = 1;

            while(set.contains(--n)) currCnt++;
            n = num;
            while(set.contains(++n)) currCnt++;

            set.add(num);

            maxCnt = Math.max(maxCnt, currCnt);
        }

        return maxCnt;
    }
}
