import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] NMT = br.readLine().split(" ");
        int N = Integer.parseInt(NMT[0]);
        int M = Integer.parseInt(NMT[1]);
        int T = Integer.parseInt(NMT[2]);

        int[][] matrix = new int[N][M];

        for (int r = 0; r < N; r++) {
            String[] s = br.readLine().split(" ");
            for (int c = 0; c < M; c++) {
                matrix[r][c] = Integer.parseInt(s[c]);
            }
        }

        int result = bfs(N, M, T, matrix);

        sb.append(result == -1 ? "Fail" : result);

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int n, int m, int t, int[][] matrix) {

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0, 0, 0 }); 

        boolean[][] visitedWithoutGram = new boolean[n][m];
        boolean[][] visitedWithGram = new boolean[n][m];

        visitedWithoutGram[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int hasGram = curr[2];
            int time = curr[3];

            if (r == n - 1 && c == m - 1) {
                if (time <= t) {
                    return time;
                } else {
                    return -1;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (hasGram == 1) { 
                        if (!visitedWithGram[nr][nc]) {
                            visitedWithGram[nr][nc] = true;
                            queue.add(new int[] { nr, nc, 1, time + 1 });
                        }
                    } else {
                        if (matrix[nr][nc] == 2) { 
                            if (!visitedWithoutGram[nr][nc]) {
                                visitedWithoutGram[nr][nc] = true;
                                queue.add(new int[] { nr, nc, 1, time + 1 });
                            }
                        } else if (matrix[nr][nc] == 0) { 
                            if (!visitedWithoutGram[nr][nc]) {
                                visitedWithoutGram[nr][nc] = true;
                                queue.add(new int[] { nr, nc, 0, time + 1 });
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}
