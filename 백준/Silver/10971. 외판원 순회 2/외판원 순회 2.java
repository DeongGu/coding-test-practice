import java.io.*;

public class Main {

	static int result, N;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		arr = new int[N][N];

		result = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split(" ");

			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(s[c]);
			}
		}

		for (int i = 0; i < N; i++) {
			permutation(i, i, visited, 0);
		}

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void permutation(int s, int e, boolean[] v, int c) {

		if (e == s) {
			boolean check = true;
			
			for(int i = 0; i < N; i++) {
				if(!v[i]) check = false;
			}
			
			if(check) {				
				result = Math.min(result, c);
				return;
			}
		}
		
		for(int i = 0; i < N; i++) {
		
			if (!v[i] && arr[e][i] > 0) {
				v[i] = true;
				c += arr[e][i];
				permutation(s, i, v, c);
				v[i] = false;
				c -= arr[e][i];
			}
			
		}


	}

}