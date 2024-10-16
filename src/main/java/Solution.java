import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt((Pair<Character, Integer> p) -> -p.getValue()));
        if(a != 0){
            pq.offer(new Pair<Character, Integer>('a', a));
        }
        if(b != 0){
            pq.offer(new Pair<Character, Integer>('b', b));
        }
        if(c != 0){
            pq.offer(new Pair<Character, Integer>('c', c));
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!pq.isEmpty()) {
            Pair<Character, Integer> cur = pq.poll();
            int val = cur.getValue();
            char ch = cur.getKey();
            if(sb.isEmpty()){
                sb.append(ch);
                val--;
                if(val != 0) {
                    pq.offer(new Pair<>(ch, val));
                }
                count++;
            }else if(sb.charAt(sb.length() - 1) != ch){
                sb.append(ch);
                val--;
                if(val != 0) {
                    pq.offer(new Pair<>(ch, val));
                }
                count = 1;
            } else if(sb.charAt(sb.length() - 1) == ch && count < 2) {
                sb.append(ch);
                val--;
                if(val != 0) {
                    pq.offer(new Pair<>(ch, val));
                }
                count = 2;
            }else if(sb.charAt(sb.length() - 1) == ch && count == 2) {
                if(pq.isEmpty()) {
                    break;
                }
                Pair<Character, Integer> p = pq.poll();
                int v = p.getValue();
                char ch2 = p.getKey();
                sb.append(ch2);
                v--;
                if(v > 0) {
                    pq.offer(new Pair<>(ch2, v));
                }
                count = 1;
                pq.offer(cur); 

            }
        }

        return sb.toString();
    }
}