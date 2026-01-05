class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] pt : edges){
            map.put(pt[0],map.getOrDefault(pt[0],0)+1);
            map.put(pt[1],map.getOrDefault(pt[1],0)+1);
        }
        int maxValue = 1;
        for(int i : map.keySet()){
            if(map.get(i)== edges.length){
                return i;
            }
        }
        return -1;
    }
}
