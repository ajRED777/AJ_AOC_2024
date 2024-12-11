package day11;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Util.TxtFileProcessor.readFileLines;

public class PlutonianPebbles {
    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day11/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> lines = readFileLines(filename);
        System.out.println("lines " + lines);
        Queue<Long> que = new LinkedList<>();
        for (String s : lines.get(0).split(" ")) {
            que.add(Long.parseLong(s));
        }
        int blinks = 25;
        while (blinks > 0) {
            System.out.println("processing blinks ->" + blinks);
            long sz = que.size();
            for (int i = 0; i < sz; i++) {
                Long stone = que.poll();
                if (stone == 0) {
                    //System.out.println(stone+"-> 1");
                    que.offer(1L);
                } else {
                    int length = (int) Math.log10(stone) + 1;
                    if (length % 2 == 0) {
                        long firstHalf = stone / (long) Math.pow(10, length / 2);
                        long secondHalf = stone % (long) Math.pow(10, length / 2);
                        //System.out.println(stone+"->"+firstHalf + " " + secondHalf);
                        que.offer(firstHalf);
                        que.offer(secondHalf);
                    } else {
                        //System.out.println(stone+"->"+stone*2024);
                        que.offer(stone * 2024);
                    }
                }
            }

            blinks--;
        }

        System.out.println("stones = " + que.size());
    }
}
