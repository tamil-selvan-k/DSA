class Solution {
public:
    vector<int> unionArray(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        int lt = 0, rt = 0;
        while(lt < nums1.size() && rt < nums2.size()) {
            int s = res.size();
            int val;
            if(nums1 [lt] == nums2[rt]) {
                val = nums1[lt];
                lt++; rt++;
            } else if(nums1[lt] < nums2[rt]) {
                val = nums1[lt++];
            } else {
                val = nums2[rt++];
            }

            if(res.empty() || res.back() != val) res.push_back(val);
        }

        while(lt < nums1.size()) {
            if(nums1[lt] != res[res.size() - 1])
                res.push_back(nums1[lt]);
            lt++;
        }

        while(rt < nums2.size()) {
            if(nums2[rt] != res[res.size() - 1])
                res.push_back(nums2[rt]);
            rt++;
        }

        return res;
    }
};
