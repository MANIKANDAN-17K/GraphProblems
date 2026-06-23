class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int neigh = q.poll();
            count++;
            for(int crs : adj.get(neigh)){
                inDegree[crs]--;
                if(inDegree[crs] == 0){
                    q.offer(crs);
                }
            }
        }
        return n == count;
    }
}
