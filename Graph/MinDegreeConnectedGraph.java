class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] mat = new boolean[n + 1][n + 1];
        int[] count = new int[n + 1];
        for (int i = 0; i < edges.length; i++) {
            mat[edges[i][0]][edges[i][1]] = true;
            mat[edges[i][1]][edges[i][0]] = true;
            count[edges[i][0]]++;
            count[edges[i][1]]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (mat[i][j] && mat[i][k] && mat[k][j]) {
                        ans = Math.min(count[i] + count[j] + count[k] - 6, ans);
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}