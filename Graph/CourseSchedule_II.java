class Solution {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        if (!this.isPossible) {
            return;
        }
        this.color.put(node, GRAY);
        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                this.isPossible = false;
            }
        }
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }
        for (int i = 0; i < numCourses; i++) {
            if (this.color.get(i) == WHITE) {
                this.dfs(i);
            }
        }
        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = this.topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }
        return order;
    }
}