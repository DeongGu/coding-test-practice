import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			String[] AB = br.readLine().split("");
			
			Stack<String> stack = new Stack<>();
			
			for(int j = 0; j < AB.length; j++) {
				if(!stack.isEmpty() && ((AB[j].equals("A") && stack.peek().equals("A")) || (AB[j].equals("B") && stack.peek().equals("B")))) {
					stack.pop();
				} else {
					stack.push(AB[j]);
				}
			}
			
			if(stack.isEmpty()) {
				result++;
			}
		}
		
		sb.append(result);

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}
}