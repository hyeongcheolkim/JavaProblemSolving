package baekjoon.q1000;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    void solution() throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var sb = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(sb.nextToken());
        int b = Integer.parseInt(sb.nextToken());

        bw.write(String.valueOf(a + b));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
