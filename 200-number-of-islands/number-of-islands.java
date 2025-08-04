class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    grid[r][c] = '0'; 
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int row = cell[0], col = cell[1];
                        for (int[] d : directions) {
                            int nr = row + d[0];
                            int nc = col + d[1];
                            if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == '1') {
                                queue.offer(new int[]{nr, nc});
                                grid[nr][nc] = '0'; 
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }
}
