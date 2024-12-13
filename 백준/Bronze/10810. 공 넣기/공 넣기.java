import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[] arr = new int[N];
		
		for(int s = 0; s < M; s++) {
			
			String[] ijk = br.readLine().split(" ");
			int i = Integer.parseInt(ijk[0]);
			int j = Integer.parseInt(ijk[1]);
			int k = Integer.parseInt(ijk[2]);
			
			for(int e = i - 1; e < j; e++) {
				arr[e] = k;
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}