class Solution {
    public int countIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 'L'){
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid,int i,int j){
        int row = grid.length;
        int col = grid[0].length;
        if(i < 0 || j < 0 || j >= col || i >= row || grid[i][j] == 'W') return;
        grid[i][j] = 'W';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid, i + 1, j + 1);
        dfs(grid, i - 1, j - 1);
        dfs(grid, i + 1, j - 1);
        dfs(grid, i - 1, j + 1);
    }
}
