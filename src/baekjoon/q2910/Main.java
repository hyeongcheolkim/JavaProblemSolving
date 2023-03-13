package baekjoon.q2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    int n, c;
    List<Integer> arr;
    Map<Integer, Integer> cnt = new HashMap<>();
    Map<Integer, Integer> ord = new HashMap<>();

    void input() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            var sb = new StringTokenizer(br.readLine());
            n = Integer.parseInt(sb.nextToken());
            c = Integer.parseInt(sb.nextToken());
            arr = Stream.of(br.readLine().split(" ")).limit(n).map(Integer::parseInt).collect(Collectors.toList());
        } catch (IOException e) {
        }
    }

    void calculateOrder() {
        int idx = 0;
        for (var e : arr) {
            cnt.merge(e, 1, Integer::sum);
            ord.putIfAbsent(e, idx++);
        }
    }

    void solution() {
        input();
        calculateOrder();
        StringBuilder sb = new StringBuilder();
        final List<Map.Entry<Integer, Integer>> arr = new ArrayList<>(cnt.entrySet());
        arr.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue()))
                return ord.get(e1.getKey()) - ord.get(e2.getKey());
            else
                return e2.getValue() - e1.getValue();
        });
        for (var e : arr)
            for (int i = 0; i < e.getValue(); ++i)
                sb.append(e.getKey().toString()).append(' ');
        System.out.print(sb);
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
