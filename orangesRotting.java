class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int tot = 0,cnt = 0;
        Queue<int[]> rotten = new LinkedList<>();
        int mins = 0;
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] != 0){tot++;}
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
            }
        }
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!rotten.isEmpty()){
            int k = rotten.size();
            cnt += k;
            for(int i =0;i<k;i++){
                int[] pos = rotten.poll();
                for(int d = 0;d<4;d++){
                    int nx = pos[0] + dx[d];
                    int ny = pos[1] + dy[d];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1){
                        continue;
                    }
                    grid[nx][ny] = 2;
                    rotten.add(new int[]{nx,ny});
                }
            }
            if(!rotten.isEmpty()) 
                mins++;
        }
        return tot == cnt ? mins : -1;
    }
}
