class Solution {
    int[] w;
    int[] prefixSum;
    int len;
    int sum = 0;

    public Solution(int[] w) {
        this.w = w;
        len = w.length;
        sa = new int[len];
        for (int i = 0; i < len; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int r = rand.nextInt(sum) + 1;
        int lo = 0;
        int hi = len - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (r < prefixSum[mid]) hi = mid - 1;
            if (r > prefixSum[mid]) lo = mid + 1;
            if (r == prefixSum[mid]) return mid;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */