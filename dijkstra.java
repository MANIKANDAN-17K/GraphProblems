class Solution {
public int[] dijkstra(int V, int[][] edges, int src) {
List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{0,src});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];
            if(dis > dist[node]) continue;
            for(int[] edge : adj.get(node)){
                int wgt = edge[1];
                int adjNode = edge[0];
                if(dis + wgt < dist[adjNode]){
                    dist[adjNode] = dis + wgt;
                    pq.offer(new int[]{dist[adjNode],adjNode});
                }
            }
        }
        return dist;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
