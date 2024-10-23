import java.io.*;
import java.util.*;

public class Main {

	static int n, homeX, homeY, rockX, rockY;
	static Deque<int[]> q;
	static boolean[] visited;
	static int[][] list;
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {

			n = Integer.parseInt(br.readLine());
			list = new int[n][2];
			result = "sad";
			q = new ArrayDeque<>();
			visited = new boolean[n];
			
			String[] homeXY = br.readLine().split(" ");
			homeX = Integer.parseInt(homeXY[0]);
			homeY = Integer.parseInt(homeXY[1]);

			for (int i = 0; i < n; i++) {

				String[] storeXY = br.readLine().split(" ");

				int storeX = Integer.parseInt(storeXY[0]);
				int storeY = Integer.parseInt(storeXY[1]);

				list[i] = new int[] { storeX, storeY };
			}
			
			String[] rockXY = br.readLine().split(" ");
			
			rockX = Integer.parseInt(rockXY[0]);
			rockY = Integer.parseInt(rockXY[1]);

			q.add(new int[] {homeX, homeY});
			
			bfs();
			
			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {
		
		int[] exey = {rockX, rockY};
		
		while(!q.isEmpty()) {
			
			int[] xy = q.pollFirst();
			
			if(getDistance(xy, exey) <= 1000) {
				result = "happy";
				return;
			}
			
			
			for(int i = 0; i < n; i++) {
				
				if(!visited[i] && getDistance(list[i], xy) <= 1000) {
					visited[i] = true;
					q.add(list[i]);
				}
				
			}
			
		}
	}
	
	static int getDistance(int[] a, int[] b) {		
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
	
}