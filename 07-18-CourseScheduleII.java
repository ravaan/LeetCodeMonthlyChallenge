class Solution {
    HashMap<Integer, GraphNode> graph = new HashMap<>();
    int[] ans;
    int i = 0;

    public int[] findOrder(int n, int[][] preq) {
        ans = new int[n];
        int[] empty = {};
        if (preq.length == 0) {
            for (; i < n; i++)
                ans[i] = i;
            return ans;
        }
        boolean[] connected = new boolean[n];
        int totalCourses = preq.length;
        for (int[] edge : preq) {
            GraphNode prev = getOrCreate(edge[1]);
            GraphNode next = getOrCreate(edge[0]);
            connected[edge[0]] = true;
            connected[edge[1]] = true;
            prev.nodes.add(edge[0]);
            next.inCount += 1;
        }
        ArrayList<Integer> noPreqCourses = new ArrayList<>();
        for (Map.Entry<Integer, GraphNode> entry : graph.entrySet()) {
            GraphNode node = entry.getValue();
            if (node.inCount == 0)
                noPreqCourses.add(entry.getKey());
        }

        int coursesDone = 0;
        while (noPreqCourses.size() > 0) {
            int course = noPreqCourses.get(noPreqCourses.size() - 1);
            noPreqCourses.remove(noPreqCourses.size() - 1);
            ans[i++] = course;
            for (int nextCourse : graph.get(course).nodes) {
                coursesDone++;
                GraphNode child = graph.get(nextCourse);
                child.inCount -= 1;
                if (child.inCount == 0)
                    noPreqCourses.add(nextCourse);
            }
        }
        if (totalCourses != coursesDone) return empty;
        for (int j = 0; j < n; j++)
            if (!connected[j])
                ans[i++] = j;
        return ans;

    }

    public GraphNode getOrCreate(int node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new GraphNode());
        }
        return graph.get(node);
    }
}

class GraphNode {
    int inCount;
    ArrayList<Integer> nodes = new ArrayList<Integer>();
}