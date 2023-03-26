package kakao.blind2023.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<String, Integer> termToValue = new HashMap<>();
    int todayValue;
    List<Integer> res = new ArrayList<>();

    int dayToValue(String dayValue) {
        final String[] split = dayValue.split("\\.");
        int year = Integer.parseInt(split[0]) * 12 * 28;
        int month = Integer.parseInt(split[1]) * 28;
        int day = Integer.parseInt(split[2]);
        return year + month + day;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        todayValue = dayToValue(today);

        for (var term : terms) {
            final String[] s = term.split(" ");
            final String type = s[0];
            final int value = Integer.parseInt(s[1]) * 28;
            termToValue.put(type, value);
        }

        for (int i = 0; i < privacies.length; ++i) {
            final String privacy = privacies[i];
            final String[] s = privacy.split(" ");
            final int value = dayToValue(s[0]);
            final int diff = termToValue.get(s[1]);
            if (value + diff <= todayValue)
                res.add(i + 1);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}