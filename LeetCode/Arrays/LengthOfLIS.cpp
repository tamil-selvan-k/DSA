class Solution {
public:
    int lengthOfLIS(vector<int>& arr) {
        int n = arr.size();
        vector<int> l(n, 1);
        int maxLen = 1;

        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j] < arr[i]) {
                    l[i] = max(l[i], l[j] + 1);
                    maxLen = max(maxLen, l[i]);
                }
            }
        }

        return maxLen;
    }
};
