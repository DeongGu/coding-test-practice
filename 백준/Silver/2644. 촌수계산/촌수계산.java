import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static int n, m, result, gx, gy;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        result = -1;

        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        String[] gxgy = br.readLine().split(" ");
        gx = Integer.parseInt(gxgy[0]);
        gy = Integer.parseInt(gxgy[1]);

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            list[x].add(y);
            list[y].add(x);
        }

        dfs(gx, 0);

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int current, int dist) {
        if (current == gy) {
            result = dist;
            return;
        }

        visited[current] = true;

        for (int neighbor : list[current]) {
            if (!visited[neighbor]) {
                dfs(neighbor, dist + 1);
            }
        }
    }
}
