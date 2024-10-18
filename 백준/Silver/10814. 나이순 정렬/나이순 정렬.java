import java.io.*;
import java.util.*;

public class Main {
	
	static class Member {
		
		int age;
		String name;
		
		public Member(int num, String str) {
			age = num;
			name = str;
		}
	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Member[] members = new Member[N];
		
		for(int i = 0; i < N; i++) {
			String[] data = br.readLine().split(" ");
			members[i] = new Member(Integer.parseInt(data[0]), data[1]);
		}
		
		Arrays.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {				
				return o1.age - o2.age;
			}
			
		});
		
		for(Member m : members) {
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}