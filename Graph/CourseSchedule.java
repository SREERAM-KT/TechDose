class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
        }
        boolean[] temp = new boolean[numCourses];
        boolean[] perm = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (cycle(i, temp, perm, adj)) {
                return false;
            }
        }
        return true;
    }

    public boolean cycle(int u, boolean[] temp, boolean[] perm, List<List<Integer>> adj) {
        if (perm[u]) {
            return false;
        }
        if (temp[u]) {
            return true;
        }
        temp[u] = true;
        for (int v : adj.get(u)) {
            if (cycle(v, temp, perm, adj)) {
                return true;
            }
        }
        temp[u] = false;
        perm[u] = true;
        return false;
    }
}