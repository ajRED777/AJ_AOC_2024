package day7;

import java.util.Arrays;
import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class BridgeRepair {
    static int R;

    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day7/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        //System.out.println(input);
        R = input.size();
        long[][] arr = new long[R][];
        for (int i = 0; i < R; i++) {
            String[] e = input.get(i).split(" ");
            e[0] = e[0].substring(0, e[0].length() - 1);
            //System.out.println(e[0]);
            arr[i] = new long[e.length];
            for (int j = 0; j < e.length; j++) {
                arr[i][j] = Long.parseLong(e[j]);
            }

        }
        //Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
        long res = 0;
        for (int i = 0; i < R; i++) {
            long expected = arr[i][0];

            if (satisfiesEquation(expected, arr[i][1], 2, arr[i])) {
                System.out.println("Equation found" + expected);
                res += expected;
            }

        }

        System.out.println(res);//1545311493300
    }

    static boolean satisfiesEquation(long expected, long curr, int i, long[] arr) {
        //System.out.println("expected: " + expected + ", curr: " + curr + ", i: " + i);
        if (expected == curr && i == arr.length)
            return true;
        if (i == arr.length)
            return false;

        return satisfiesEquation(expected, curr * arr[i], i + 1, arr) ||
                satisfiesEquation(expected, curr + arr[i], i + 1, arr) ||
                satisfiesEquation(expected, combineNum(curr, arr[i]), i + 1, arr);
    }

    static long combineNum(long num1, long num2) {
        return Long.parseLong(String.valueOf(num1) + String.valueOf(num2));
    }

}
