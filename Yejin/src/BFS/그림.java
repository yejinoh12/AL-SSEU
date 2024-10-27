package BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 그림 {

    static int n, m;
    static int[][] graph, visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        graph = new int[n][m];
        visited = new int[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = input[j];
            }
        }

        int cnt = 0;        //그림의 개수
        int maxSize = 0;    //가장 큰 그림의 넒이

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //그림이 그려져 있고 방문하지 않은 노드만 방문
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;
                    int size = bfs(i, j);
                    if (size > maxSize) maxSize = size;
                }
            }
        }

        bw.write(cnt + "\n" + maxSize + "");
        bw.flush();
        bw.close();
    }

    static int bfs(int x, int y) {

        //큐 생성
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = 1;

        int size = 1;

        //큐가 빌때까지 반복
        while (!q.isEmpty()) {

            //노드를 꺼내고 인근 노드 탐색
            int[] node = q.poll();
            x = node[0];
            y = node[1];

            //4방향
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위에서 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                //그림이 그려져 있지 않거나 이미 방문한 경우
                if (visited[nx][ny] == 1 || graph[nx][ny] == 0) continue;

                //큐에 넣고 방문 처리
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = 1;
                size++;

            }
        }

        return size;

    }
}
