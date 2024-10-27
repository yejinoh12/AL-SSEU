package 백트레킹.N과M;

import java.io.*;
import java.util.Arrays;

public class N과M_6 {

    static int N, M;
    static int[] arr, ans;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        v = new boolean[N];

        ans = new int[M];

        backTracking(0,0);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }

    static void backTracking(int index, int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < N; i++) {

            if (!v[i]) {
                v[i] = true;
                ans[depth] = arr[i];
                backTracking(i + 1, depth + 1);
                v[i] = false;
            }
        }
    }
}
