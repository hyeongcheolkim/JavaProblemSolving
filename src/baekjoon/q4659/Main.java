package baekjoon.q4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private String[] vowels = {"a", "e", "i", "o", "u"};

    private String accept(String pw) {
        return "<" + pw + "> is acceptable.";
    }

    private String notAccept(String pw) {
        return "<" + pw + "> is not acceptable.";
    }

    String input() {
        try {
            return br.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    boolean isVowel(char c) {
        for (var e : vowels)
            if (e.charAt(0) == c)
                return true;
        return false;
    }

    boolean containVowel(String pw){
        for (var e : vowels)
            if (pw.contains(e))
                return true;
        return false;
    }

    boolean check(String pw) {
        if(!containVowel(pw))
            return false;

        char[] chars = pw.toCharArray();
        char prev = '0';
        int continuousAlpha = 1;
        int continuousVow = 0;
        int continuousCon = 0;
        for (var c : chars) {
            if (prev == c)
                ++continuousAlpha;
            else
                continuousAlpha = 1;
            if (isVowel(c)) {
                ++continuousVow;
                continuousCon = 0;
            } else {
                continuousVow = 0;
                ++continuousCon;
            }
            prev = c;

            if (continuousCon == 3 || continuousVow == 3)
                return false;
            if (continuousAlpha == 2 && (prev != 'e' && prev != 'o'))
                return false;
        }
        return true;
    }

    void solution() {
        StringBuilder sb = new StringBuilder();
        String pw = null;
        while (!(pw = input()).equals("end")) {
            if (check(pw))
                sb.append(accept(pw)).append('\n');
            else
                sb.append(notAccept(pw)).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
