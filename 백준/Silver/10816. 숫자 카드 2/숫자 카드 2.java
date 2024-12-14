import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		String[] cards = br.readLine().split(" ");
		
		int M = Integer.parseInt(br.readLine());
		
		String[] resultCards = br.readLine().split(" ");
		
		HashMap<String, Integer> result = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			
			if(result.containsKey(cards[i])) {
				result.put(cards[i],result.get(cards[i])+1);
			}else {
				result.put(cards[i], 1);
			}
		}
		
		for(int i = 0; i < M; i++) {
			
			if(result.get(resultCards[i]) == null) {
				sb.append(0).append(" ");
			}else {				
				sb.append(result.get(resultCards[i])).append(" ");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}