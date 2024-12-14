package day13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Util.TxtFileProcessor.readFileLines;

public class ClawContraption2 {
    static int R = 0;
    static HashMap<StateKey, Long> memo;
    public static void main(String[] args) {
        List<String> input = readFileLines(13, true);
        R = input.size();
        Pattern pattern = Pattern.compile("[+-]?\\d+");
        int m = 0;
        long[][] machines = new long[(R / 4) + 1][6];
        for (int i = 0; i < R; i += 4) {
            Matcher matcher = pattern.matcher(input.get(i) + input.get(i + 1) + input.get(i + 2));
            int j = 0;
            while (matcher.find()) {
                machines[m][j++] = Long.parseLong(matcher.group());
            }
            m++;
        }

        long res = 0;
        for (long[] machine : machines) {
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

    static long check(long i, long j, long[] machine, int a, int b) {

        //if (a == 100 || b == 100) return Long.MAX_VALUE;
        if (i > machine[4] || j > machine[5]) return Long.MAX_VALUE;

        if (i == machine[4] && j == machine[5]) return a + b;
        var key = new StateKey(i, j, a, b);;
        if(memo.containsKey(key)) return memo.get(key);
        System.out.println("i=" + i + ", j=" + j);
        long result = Math.min(
                check(i + machine[0], j + machine[1], machine, a + 1, b),
                check(i + machine[2], j + machine[3], machine, a, b + 1)
        );
        memo.put(key, result);
        return result;
    }


    static class StateKey {
        long i, j, a, b;

        StateKey(long i, long j, long a, long b) {
            this.i = i;
            this.j = j;
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, a, b);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            StateKey other = (StateKey) obj;
            return i == other.i && j == other.j && a == other.a && b == other.b;
        }
    }

}

