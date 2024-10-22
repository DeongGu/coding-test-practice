import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(arr[i] != 0) {
				for(int j = 0; j < arr[i]; j++) {					
					sb.append(i).append("\n");
				}
			}
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}