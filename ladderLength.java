class Pair<K,V>{
    private K k;
    private V v;
    public Pair(K k,V v){
        this.k = k;
        this.v = v;
    }
    public K getKey(){
        return k;
    }
    public V getValue(){
        return v;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord,1));
        Set<String> wl = new HashSet<>(wordList);
        if(wl.contains(beginWord)){
            wl.remove(beginWord);
        }
        while(!q.isEmpty()){
            String word = q.peek().getKey();
            int step = q.peek().getValue();
            q.poll();
            if(endWord.equals(word)) return step;
            for(int i = 0;i<word.length();i++){
                char[] arr = word.toCharArray();
                char original = arr[i];
                for(char ch = 'a'; ch <= 'z';ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(wl.contains(newWord)){
                        wl.remove(newWord);
                        q.add(new Pair<>(newWord,step+1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}
