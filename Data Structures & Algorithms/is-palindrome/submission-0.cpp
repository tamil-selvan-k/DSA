class Solution {
public:
    bool isPalindrome(string s) {
        int lt = 0, rt = s.length() - 1;
        while(lt < rt) {
            if(!isalnum(s[lt])) lt++;
            if(!isalnum(s[rt])) rt--;

            if(isalnum(s[lt]) && isalnum(s[rt])) {
                if(tolower(s[lt]) != tolower(s[rt])) {
                    return false;
                }
                lt++; rt--;
            }
        }
        return true;
    }
};