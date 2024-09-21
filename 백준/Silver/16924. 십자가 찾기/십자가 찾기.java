import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[][] matrix = new int[N][M];

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		Stack<int[]> stack = new Stack<>();
		Stack<int[]> resultStack = new Stack<>();

		for (int r = 0; r < N; r++) {

			String[] s = br.readLine().split("");

			for (int c = 0; c < M; c++) {

				if (s[c].equals("*")) {
					matrix[r][c] = 1;

					int[] star = new int[3];
					star[0] = r;
					star[1] = c;

					stack.push(star);
				}
			}
		}

		boolean end = false;

		while (!stack.isEmpty()) {

			if (end)
				break;
			int[] rcl = stack.pop();

			int r = rcl[0];
			int c = rcl[1];

			int check = 0;

			for (int k = 0; k < Math.min(N, M); k++) {
				check = 0;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i] * (k+1);
					int nc = c + dc[i] * (k+1);
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && matrix[nr][nc] >= 1) {
						check++;
					}
				}

				if (check == 4) {
					
					matrix[r][c]++;
					
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i] * (k+1);
						int nc = c + dc[i] * (k+1);
						
						matrix[nr][nc]++;
					}
					
					int[] nrcl = new int[3];
					nrcl[0] = r;
					nrcl[1] = c;
					nrcl[2] = k+1;
					resultStack.push(nrcl);
				}else {
					break;
				}

			}
		}
		
		for(int r = 0; r < N; r++) {
			if(end) break;
			for(int c = 0; c < M; c++) {
				if(matrix[r][c] == 1) {
					end = true;
					break;
				}
			}
		}
		
		
		if(end || resultStack.isEmpty()) {
			sb.append(-1);
		}else {
			
			sb.append(resultStack.size()).append("\n");
			
			while(!resultStack.isEmpty()) {
				
				int[] result = resultStack.pop();
				
				sb.append(result[0]+1).append(" ").append(result[1]+1).append(" ").append(result[2]).append("\n");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}