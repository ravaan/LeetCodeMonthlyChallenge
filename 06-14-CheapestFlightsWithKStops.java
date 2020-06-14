class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            graph.putIfAbsent(flights[i][0], new ArrayList<int[]>());
            graph.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        int stops = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        q.add(new int[]{-1, 0});
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == -1) {
                if (stops > K) break;
                q.add(new int[]{-1, 0});
                stops++;
            }
            if (curr[0] == dst) {
                ans = Math.min(ans, curr[1]);
                continue;
            }
            if (!graph.containsKey(curr[0])) continue;
            for (int[] i : graph.get(curr[0])) {
                if (curr[1] + i[1] > ans) continue;
                q.add(new int[]{i[0], curr[1] + i[1]});
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}