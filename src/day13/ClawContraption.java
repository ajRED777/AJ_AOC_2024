package day13;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Util.TxtFileProcessor.readFileLines;

import java.util.*;

public class ClawContraption {
    static int R = 0;
    static HashMap<String, Long> memo = new HashMap<>();
    public static void main(String[] args) {
        List<String> input = readFileLines(13, false);
        R = input.size();
        Pattern pattern = Pattern.compile("[+-]?\\d+");
        int m = 0;
        int[][] machines = new int[(R / 4) + 1][6];
        for (int i = 0; i < R; i += 4) {
            Matcher matcher = pattern.matcher(input.get(i) + input.get(i + 1) + input.get(i + 2));
            int j = 0;
            while (matcher.find()) {
                machines[m][j++] = Integer.parseInt(matcher.group());
            }
            m++;
        }

        long res = 0;
        for (int[] machine : machines) {
            memo = new HashMap<>();
            System.out.println("processing: "+ Arrays.toString(machine));
            long cost = check(0, 0, machine, 0, 0);
            if (cost != Long.MAX_VALUE) {
                System.out.println("Cost= " +cost);
                res += cost;
            }
        }

        System.out.println("Total cost: " + res);
    }

    static long check(int i, int j, int[] machine, int a, int b) {

        if (a == 100 || b == 100) return Long.MAX_VALUE;
        if (i > machine[4] || j > machine[5]) return Long.MAX_VALUE;

        if (i == machine[4] && j == machine[5]) return a * 3L + b;
        String key = i+"-"+j+"-"+"-"+a+"-"+b;
        if(memo.containsKey(key)) return memo.get(key);
        System.out.println("i=" + i + ", j=" + j);
        long result = Math.min(
                check(i + machine[0], j + machine[1], machine, a + 1, b),
                check(i + machine[2], j + machine[3], machine, a, b + 1)
        );
        memo.put(key, result);
        return result;
    }
}

