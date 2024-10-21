import java.io.*;
import java.util.*;

public class Main {
	
	static class Student {
		
		String name;
		int korean, english, math;
		
		public Student(String str, int k, int e, int m) {
			name = str;
			korean = k;
			english = e;
			math = m;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		Student[] students = new Student[N];
		
		for(int i = 0; i < N; i++) {
			String[] nkem = br.readLine().split(" ");
			String n  = nkem[0];
			int k = Integer.parseInt(nkem[1]);
			int e = Integer.parseInt(nkem[2]);
			int m = Integer.parseInt(nkem[3]);
			students[i] = new Student(n, k, e, m);
		}
		
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				if(o1.korean == o2.korean && o1.english == o2.english && o1.math == o2.math) {
					return o1.name.compareTo(o2.name);
				}else if(o1.korean == o2.korean && o1.english == o2.english){
					return o2.math - o1.math;
				}else if(o1.korean == o2.korean) {
					return o1.english - o2.english;
				}else {
					return o2.korean - o1.korean;
				}
			}
		});
	
		for(int i = 0; i < N; i++) {
			sb.append(students[i].name).append("\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}
