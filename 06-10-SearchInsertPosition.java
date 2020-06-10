class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi);
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            if (nums[mid] > target) hi = mid - 1;
        }
        return lo;

    }
}