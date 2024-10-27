package 백트레킹.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N과M_2 {

    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        visited = new boolean[N];
        arr = new int[M];

        backTracking(0, 0);

    }

    static void backTracking(int index, int depth){

        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = index; i < N; i++){

            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
