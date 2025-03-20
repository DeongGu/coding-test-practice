import java.util.*;

class Solution {
    
    static int maxDistance;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n+1];
        List<Integer>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        maxDistance = 0;
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] w : edge){
            list[w[0]].add(w[1]);
            list[w[1]].add(w[0]);
        }
        
        bfs(visited, list, distance);

        for(int i = 1; i <= n; i++){
            if(distance[i] == maxDistance) answer++;
        }
        
        return answer;
    }
    
    static void bfs(boolean[] visited, List<Integer>[] list,  int[] distance){
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {1, 0});
        visited[1] = true;
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int v = curr[0];
            int d = curr[1];
            
            for(int w : list[v]){
                
                if(!visited[w]){
                    visited[w] = true;
                    queue.add(new int[] {w, d+1});
                    
                    if(distance[w] != 0){
                        distance[w] = Math.min(distance[w], d + 1);
                    }else{
                         distance[w] = d + 1;
                    }
                    
                    maxDistance = Math.max(maxDistance, distance[w]);
                }
            }
            
        }
        
    }
}