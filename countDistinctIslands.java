class Solution {
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 'L'){
                    List<String> shape= new ArrayList<>();
                    dfs(i,j,i,j,grid,vis,shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }
    private void dfs(int r,int c,int br,int bc,char[][] grid,boolean[][] vis,List<String> shape){
        vis[r][c] = true;
        shape.add((r-br)+"-"+(c-bc));
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(nx>=0 && ny>=0 && nx <grid.length && ny<grid[0].length && !vis[nx][ny] && grid[nx][ny] == 'L'){
                dfs(nx,ny,br,bc,grid,vis,shape);
            }
        }
    }
}
