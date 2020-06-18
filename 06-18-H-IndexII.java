class Solution {
    public int hIndex(int[] cit) {
        int len = cit.length;
        if (len == 0) return 0;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (cit[mid] < len - mid) lo = mid + 1;
            else if (cit[mid] > len - mid) hi = mid - 1;
            else return len - mid;
        }
        return len - lo;
    }
}