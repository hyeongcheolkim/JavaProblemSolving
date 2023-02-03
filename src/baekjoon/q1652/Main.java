package baekjoon.q1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    int n, h, v;
    char board[][];
    boolean vst[][];

    void solution() throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n + 2][n + 2];
        for (int i = 1; i <= n; ++i) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= n; ++j)
                board[i][j] = split[j - 1].charAt(0);
        }

        vst = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= n; ++j) {
                if (board[i][j] == 0 || board[i][j] == 'X' || vst[i][j])
                    continue;
                int len = 0;
                while (board[i][j] == '.') {
                    vst[i][j] = true;
                    ++j;
                    ++len;
                }
                if (len > 1)
                    ++h;
            }
        Stream.of(vst).forEach(e -> Arrays.fill(e, false));
        for (int j = 1; j <= n; ++j)
            for (int i = 1; i <= n; ++i) {
                if (board[i][j] == 0 || board[i][j] == 'X' || vst[i][j])
                    continue;
                int len = 0;
                while (board[i][j] == '.') {
                    vst[i][j] = true;
                    ++i;
                    ++len;
                }
                if (len > 1)
                    ++v;
            }
        System.out.print(h + " " + v);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
