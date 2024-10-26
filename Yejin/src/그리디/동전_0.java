package 그리디;

//문제
//준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
//동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

//아이디어(수정)
// 목표값을 가장 큰 동전으로 나누기
// 목표값은 목표값 % 가장큰 동전으로 갱신

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 동전_0 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0]; //동전의 종류
        int K = input[1]; //동전으로 만들어야 한는 값

        //동전 입력
        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        //오름차순 정렬되어 있는 동전을 내림차순으로 변경
        Collections.reverse(coins);

        int ans = 0;

       for(int coin : coins){
           ans += K / coin;
           K = K % coin;
           if(K == 0) break;
       }

        System.out.println(ans);
    }
}

