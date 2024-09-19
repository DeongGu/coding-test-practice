import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[][] matrix = new String[N][N];

		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
		String[] mobis = {"O", "B", "I", "S"};

		Stack<int[]> stack = new Stack<>();

		int result = 0;

		for (int r = 0; r < N; r++) {

			String[] alpa = br.readLine().split("");

			for (int c = 0; c < N; c++) {

				matrix[r][c] = alpa[c];
				if (matrix[r][c].equals("M")) {

					int[] rc = new int[2];
					rc[0] = r;
					rc[1] = c;
					stack.push(rc);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			
			int[] rc = stack.pop();
			
			int r = rc[0];
			int c = rc[1];
			
			for(int i = 0; i < 8; i++) {
				
				int check = 0;
				
				for(int j = 0; j < 4; j++) {
					int nr = r + dr[i] * (j+1);
					int nc = c + dc[i] * (j+1);
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if(matrix[nr][nc].equals(mobis[j])){
							check++;
						}else {
							break;
						}
					}
				}
				
				if(check == 4) result++;
			}
			
		}

		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}