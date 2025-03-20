import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
 
        List<int[]>[] graph = new ArrayList[N+1];
  
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
       for(int[] r : road){
           int a = r[0];
           int b = r[1];
           int c = r[2];
           
           graph[a].add(new int[] {b, c});
           graph[b].add(new int[] {a, c});
       }
        
        return dijkstra(N, graph, K);
    }
    
    static int dijkstra(int N, List<int[]>[] graph, int K){
        
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, 1});
        
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            int time = curr[0];
            int location = curr[1];
            
            
            if(time > dist[location]) continue;
            
            for(int[] w : graph[location]){
             
                int newTime = time + w[1];
                
                if(newTime < dist[w[0]]){
                    dist[w[0]] = newTime;
                    pq.add(new int[] {newTime, w[0]});
                }
            }
            
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }
        return count;
        
    }
}