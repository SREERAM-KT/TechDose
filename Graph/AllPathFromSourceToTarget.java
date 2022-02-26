class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0)
            return null;
        int n = graph.length;
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        curr.add(0);
        dfs(graph, 0, n - 1, curr, answer);
        return answer;
    }

    public void dfs(int[][] graph, int s, int d, List<Integer> curr, List<List<Integer>> answer) {
        if (s == d) {
            answer.add(new ArrayList<>(curr));
            return;
        }
        for (int child : graph[s]) {
            curr.add(child);
            dfs(graph, child, d, curr, answer);
            curr.remove(curr.size() - 1);
        }
    }
}