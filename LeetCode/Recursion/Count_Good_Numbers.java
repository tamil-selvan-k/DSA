class Solution {
    private final long MOD = 1_000_000_007;

    long power(long base, long ex) {
        if(ex == 0) return 1;

        long half = power(base, ex / 2);
        long res = (half * half) % MOD;

        if(ex % 2 != 0) {
            res = (res * base) % MOD;
        }

        return res;
    }

    public int countGoodNumbers(long n) {
        long o = n / 2;
        long e = (n + 1) / 2;

        long odd = power(4, o);
        long even = power(5, e);

        return (int)((even * odd) % MOD);
    }
}

