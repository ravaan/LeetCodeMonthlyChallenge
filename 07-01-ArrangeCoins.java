class Solution {
    public int arrangeCoins(int n) {
        long lo = 0, hi = n, mid, curr;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            curr = mid * (mid + 1) / 2;
            if (curr == n) return (int) mid;
            if (curr > n) hi = mid - 1;
            if (curr < n) lo = mid + 1;
        }
        return (int) hi;
    }
}