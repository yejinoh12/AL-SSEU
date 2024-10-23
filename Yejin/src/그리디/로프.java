package 그리디;

//아이디어
//로프가 들 수 있는 무게 * 개수-- 을 리버스한 값을 곱해서
//그중에서 가장 큰 값을 선택

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 로프 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //정렬
        Arrays.sort(arr);

        int k = N;
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tmp.add(arr[i] * k--);
        }

        //가장 큰 값을 선택
        bw.write(Collections.max(tmp) + "");
        bw.flush();
        bw.close();

    }
}
