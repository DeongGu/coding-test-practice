import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N];
		
		String[] s = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			matrix[i] = Integer.parseInt(s[i]);
		}
		
		sb.append(bfs());
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs() {
		
		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			int location = curr[0];
			int count = curr[1];
			
			if(location == N - 1) return count;
			
			for(int i = 1; i <= matrix[location]; i++) {
				
				int newLocation = location + i;
				
				if(newLocation < N && !visited[newLocation]) {
					visited[newLocation] = true;					
					queue.add(new int[] {location + i, count+1});
				}
			}
			
		}
		
		return -1;
		
	}

}