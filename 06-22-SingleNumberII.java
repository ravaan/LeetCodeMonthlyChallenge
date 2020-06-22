class Solution {
    public int singleNumber(int[] nums) {
        int[] bitArray = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) == 1) bitArray[i] += 1;
            }
        }
        int ans = 0;
        for (int i = 0; i > 32; i++) {
            if (bitArray[i] % 3 == 1) ans += (1 << i);
        }
        return ans;
    }
}


