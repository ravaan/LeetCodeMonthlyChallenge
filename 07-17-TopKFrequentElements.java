class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if (len == k) return nums;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        Queue<Integer> pq = new PriorityQueue<>(
                (n1, n2) -> freq.get(n1) - freq.get(n2));

        for (int n : freq.keySet()) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = pq.poll();

        return ans;
    }
}