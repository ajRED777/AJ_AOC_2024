package day11;

import java.util.HashMap;
import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class PlutonianPebbles2 {
    static HashMap<Long, Long>[] cache = new HashMap[76];

    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day11/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> lines = readFileLines(filename);
        System.out.println("lines " + lines);

        int blinks = 75;
        Long stonesCount = 0L;
        for (String s : lines.get(0).split(" ")) {
            stonesCount += countStoneSplit(Long.parseLong(s), blinks);
        }
        System.out.println("stones = " + stonesCount);
    }

    static Long countStoneSplit(Long stone, int blinks) {
        if (cache[blinks] != null && cache[blinks].containsKey(stone))
            return cache[blinks].get(stone);
        if (blinks == 0)
            return 1L;
        long count;
        if (stone == 0) {
            //System.out.println(stone+"-> 1");
            count = countStoneSplit(1L, blinks - 1);
            //System.out.println(stone+"== "+count);
        } else {
            int length = (int) Math.log10(stone) + 1;
            if (length % 2 == 0) {
                long firstHalf = stone / (long) Math.pow(10, length / 2);
                long secondHalf = stone % (long) Math.pow(10, length / 2);
                //System.out.println(stone+"->"+firstHalf + " " + secondHalf);
                count = countStoneSplit(firstHalf, blinks - 1) + countStoneSplit(secondHalf, blinks - 1);
                //System.out.println(stone+"== "+count);
            } else {
                //System.out.println(stone+"->"+stone*2024);
                count = countStoneSplit(stone * 2024, blinks - 1);
                //System.out.println(stone+"== "+count);
            }
        }
        if (cache[blinks] == null)
            cache[blinks] = new HashMap<>();
        cache[blinks].put(stone, count);
        return count;

    }
}
