class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] temp = new boolean[numCourses];
        boolean[] perm = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (cycle(i, temp, perm, adj, list)) {
                return new int[0];
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; !list.isEmpty(); i++) {
            result[i] = list.remove(0);
        }
        return result;
    }

    public boolean cycle(int u, boolean[] temp, boolean[] perm, List<List<Integer>> adj, List<Integer> list) {
        if (temp[u]) {
            return true;
        }
        if (perm[u]) {
            return false;
        }
        temp[u] = true;
        for (int v : adj.get(u)) {
            if (cycle(v, temp, perm, adj, list)) {
                return true;
            }
        }
        list.add(u);
        perm[u] = true;
        temp[u] = false;
        return false;
    }
}