import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] wh = br.readLine().split(" ");

		int w = Integer.parseInt(wh[0]);
		int h = Integer.parseInt(wh[1]);

		String[] pq = br.readLine().split(" ");

		int p = Integer.parseInt(pq[0]);
		int q = Integer.parseInt(pq[1]);

		int t = Integer.parseInt(br.readLine());

		p = (p+t)%(2*w);
		q = (q+t)%(2*h);

		if(p > w) p = 2 * w - p;
		if(q > h) q = 2 * h - q;
		
		sb.append(p).append(" ").append(q);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}