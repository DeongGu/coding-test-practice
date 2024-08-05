import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().trim().split(" ");

		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		int[][] room = new int[2][6];

		int count = 0;

		for (int i = 0; i < N; i++) {
			String[] info = br.readLine().trim().split(" ");

			int gender = Integer.parseInt(info[0]);
			int grade = Integer.parseInt(info[1]) - 1;

			room[gender][grade]++;

		}
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 6; k++) {
				if (room[j][k] != 0) {
					
					if(room[j][k]/K == 0 && room[j][k] % K != 0) {
						count++;
					}else if(room[j][k]%K ==0) {
						count++;
					}else {
						count += (room[j][k]/K) + 1;						
					}
				}
			}
		}
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}