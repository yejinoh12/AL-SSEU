package 백트레킹.N과M;

import java.io.*;
import java.util.Arrays;

public class N과M_4 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        arr = new int[M];

        backTracking(0, 0);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }

    static void backTracking(int index, int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < N; i++) {

            arr[depth] = i + 1;
            backTracking(i, depth + 1);

        }
    }
}
