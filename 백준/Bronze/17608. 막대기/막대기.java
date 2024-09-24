import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int max = 0;
		int maxIdx = -1;
		
		for(int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			if(max <= h) {
				maxIdx = i;
				max = h;
			}
			stack.push(h);
		}
		
		
		int result = 0;
		int count = 0;
		int start = 0;
		
		while(count != N-maxIdx) {
			int check = stack.pop();

			if(check > start){
				start = check;
				result++;
			}
			count++;
			
		}
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}