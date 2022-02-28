class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int[][] mat = new int[n * 3][m * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '\\') {
                    mat[i * 3][j * 3] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3 + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    mat[i * 3][j * 3 + 2] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    dfs(mat, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] mat, int i, int j) {
        int n = mat.length;
        int m = mat[0].length;
        if (i < 0 || j >= m || j < 0 || i >= n || mat[i][j] == 1) {
            return;
        }
        mat[i][j] = 1;
        int[] dir = { 0, -1, 0, 1, 0 };
        for (int k = 0; k < 4; k++) {
            dfs(mat, i + dir[k], j + dir[k + 1]);
        }
    }
}