class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList();

        ArrayList<ArrayList> pow = new ArrayList();
        for (int num : nums) pow.add(new ArrayList());

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> set = new ArrayList();
            for (int k = 0; k < i; k++)
                if (nums[i] % nums[k] == 0 && set.size() < pow.get(k).size())
                    set = pow.get(k);

            pow.get(i).addAll(set);
            pow.get(i).add(nums[i]);
        }
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < n; i++)
            if (ans.size() < pow.get(i).size()) ans = pow.get(i);
        return ans;
    }
}