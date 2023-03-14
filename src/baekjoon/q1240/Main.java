package baekjoon.q1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int n, m;
    List<List<Pair>> graph;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void input() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = Stream.generate(() -> new ArrayList<Pair>())
                    .limit(n + 1)
                    .collect(Collectors.toList());

            for (int i = 0; i < n - 1; ++i) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Pair(cost, to));
                graph.get(to).add(new Pair(cost, from));
            }
        } catch (IOException e) {
        }
    }

    void solution() {
        input();
        final StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < m; ++i) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                AtomicInteger ret = new AtomicInteger(0);
                boolean[] vst = new boolean[n + 1];
                vst[node1] = true;
                calculateDistance(ret, vst, node1, node2, 0);
                sb.append(ret.get()).append('\n');
            }
        } catch (IOException e) {
        }
        System.out.print(sb);
    }

    private void calculateDistance(AtomicInteger ret, boolean[] vst, int nowNode, int targetNode, int accCost) {
        if (nowNode == targetNode) {
            ret.set(accCost);
            return;
        }
        for (var e : graph.get(nowNode)) {
            int nowCost = e.first;
            int next = e.second;
            if (vst[next])
                continue;
            vst[next] = true;
            calculateDistance(ret, vst, next, targetNode, accCost + nowCost);
        }
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
