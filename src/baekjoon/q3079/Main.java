package baekjoon.q3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    long n, m;
    ArrayList<Long> cost = new ArrayList<>();

    void input() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            m = Long.parseLong(st.nextToken());
            cost.ensureCapacity((int) n);
            while (n-- != 0)
                cost.add(Long.parseLong(br.readLine()));
        } catch (IOException e) {
        }
    }

    boolean check(long val) {
        long cnt = 0;
        for (final var e : cost){
            cnt += val / e;
            if(cnt >= m)
                break;
        }
        return cnt >= m;
    }

    void solution() {
        input();
        cost.sort(Comparator.naturalOrder());
        long lt = -1;
        long rt = cost.get(cost.size() - 1) * m + 1;
        while (lt + 1 < rt) {
            long mid = lt + (rt - lt) / 2;
            if (check(mid))
                rt = mid;
            else
                lt = mid;
        }
        System.out.print(rt);
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}