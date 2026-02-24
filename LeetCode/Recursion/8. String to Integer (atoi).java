class Solution {
    private long atoi(String s, long num, int ind) {
        if(ind == s.length()) {
            return num;
        }
        char ch = s.charAt(ind);

        if(num > Integer.MAX_VALUE) return num;
        else if(ind == 0 && (ch == '-' || ch == '+')) 
            return atoi(s, num, ind+1);
        else if(!Character.isDigit(ch)) return num;

        return atoi(s, (num * 10) + (s.charAt(ind) - '0'), ind + 1);
    }
    public int myAtoi(String input) {
        long res = 0L;
        String s = input.trim();
        int n = s.length();
        int sign = (n > 1 && s.charAt(0) == '-')?-1:1;
        // if(!s.charAt(i))
        res = atoi(s, 0, 0);
        res *= sign;
        if(res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
}
