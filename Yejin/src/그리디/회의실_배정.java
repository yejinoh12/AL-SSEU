package 그리디;

//아이디어(참고)
//종료시간을 기준으로 오름차순 정리
//반복문을 돌면서 종료시간보다 시작시간이 같거나 이후라면 선택

import java.io.*;
import java.util.Arrays;

public class 회의실_배정{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for(int i = 0; i < N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetings[i][0] = input[0];
            meetings[i][1] = input[1];
        }

        //종료 시간을 기준으로 정렬(같다면 시작 시간이 기준)
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        //인덱스 0번 회의는 무조건 포함
        int ans = 1;

        //인덱스 0번 회의의 종료시간
        int end = meetings[0][1];

        //인덱스 1번 회의부터 반복문을 돌기
        //회의의 시작시간이 선택된 회의의 종료시간과 같거나 크다면 그 회의를 선택
        //정답 카운트하고, 종료시간 갱신
        for(int i = 1; i < N; i++){
            if(meetings[i][0] >=  end){
                ans ++;
                end = meetings[i][1];
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();

    }
}
