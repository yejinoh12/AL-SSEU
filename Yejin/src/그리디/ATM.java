package 그리디;

//아이디어
//오름차순 정렬한 뒤 자신이 걸리는 수와 대기 시간(앞 사람들의 처리시간)을 모두 더하기

import java.io.*;
import java.util.Arrays;

public class ATM {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int processing = 0;
        int ans = 0;

        // 0 1 3 6 9 -> 19 (대기시간)
        // 1 2 3 3 4 -> 13 (처리시간)

        for (int i = 0; i < N; i++) {
            processing += arr[i];    //처리 시간
            ans += processing;       //총 소요시간(대기 시간 포함)

            //System.out.println(processing);
            //System.out.println(ans);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();

    }
}
