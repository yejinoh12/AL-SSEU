package 그리디;

//newA[B의 최대값 인덱스] = A의 최소값

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 보물 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] newA = new int[N];

        ArrayList<Integer> AIndex = new ArrayList<>();
        ArrayList<Integer> BIndex = new ArrayList<>();

        for(int i = 0; i < N; i++){
            AIndex.add(A[i]);
            BIndex.add(B[i]);
        }

        for(int i = 0; i < N; i++){

            int maxIdxOfB = BIndex.indexOf(Collections.max(BIndex));
            BIndex.set(maxIdxOfB, -1);

            int minIdxOfA = AIndex.indexOf(Collections.min(AIndex));
            newA[maxIdxOfB] = AIndex.get(minIdxOfA);
            AIndex.remove(minIdxOfA);
        }

        int ans = 0;

        for(int i = 0; i < N; i++){
            ans += newA[i] * B[i];
        }

        System.out.println(ans);

    }
}
