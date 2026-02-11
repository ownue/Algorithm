import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // 특정 칸 (r, c) 와 인접한 칸은
    // 위: (r-1, c)
    // 아래: (r+1, c)
    // 왼쪽: (r, c)
    // 오른쪽: (r, c)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean[][] blindVisited;
    static char[][] map;
    static int N;

    public static void main(String[] args) throws Exception {
        int groupCount = 0, rgcbGroupCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 2차원 배열 채우기
        map = new char[N][N];
        visited = new boolean[N][N];
        blindVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                visited[i][j] = false;
                blindVisited[i][j] = false;
            }
        }

        // dfs 돌고, 개수 카운트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j], false, visited);
                    groupCount++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!blindVisited[i][j]) {
                    dfs(i, j, map[i][j], true, blindVisited);
                    rgcbGroupCount++;
                }
            }
        }

        System.out.println(groupCount + " " + rgcbGroupCount);
    }

    static void dfs(int r, int c, char ch, boolean rgcb, boolean[][] v) {
        v[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                // 색약일 시
                if (rgcb) {
                    // 현재 B를 탐색 중이고, 다음 것도 B면서 방문한 적 없다면
                    if (ch == 'B' && map[nr][nc] == ch && !v[nr][nc]) {
                        dfs(nr, nc, ch, rgcb, v);   // 계속 탐색
                    }
                    // 현재 R이나 G를 탐색 중이고, 다음 것도 R이나 G면서 방문한 적 없다면
                    else if (ch == 'R' || ch == 'G') {
                        if ((map[nr][nc] == 'R' || map[nr][nc] == 'G') && !v[nr][nc]) {
                            dfs(nr, nc, ch, rgcb, v);   // 계속 탐색
                        }
                    }
                }
                // 색약 아닐 시 같은 그룹이고 방문한 적 없다면
                else {
                    if (map[nr][nc] == ch && !v[nr][nc]) {
                        // 계속 탐색
                        dfs(nr, nc, ch, rgcb, v);
                    }
                }
            }
        }
    }
}