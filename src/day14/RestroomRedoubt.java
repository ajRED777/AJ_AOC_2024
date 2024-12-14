package day14;

import java.util.Arrays;
import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class RestroomRedoubt {
//    final static int C = 11;
//    final static int R = 7;
    final static int C = 101;
    final static int R = 103;
    public static void main(String[] args) {
        List<String> input = readFileLines(14, false);
        int[][] finalPositions = new int[R][C];
        for(String line : input) {
            String[] split = line.split(" ");
            String[] p = split[0].substring(split[0].indexOf("=")+1).split(",");
            String[] v = split[1].substring(split[1].indexOf("=")+1).split(",");
            //System.out.println("p: "+ Arrays.toString(p) +" v: "+ Arrays.toString(v));
            int py = ((Integer.parseInt(p[0]) + 100*Integer.parseInt(v[0]))%C + C)%C;
            //System.out.println("py without mod: "+ Integer.parseInt(p[0]) + 100*Integer.parseInt(v[0]));
            int px = ((Integer.parseInt(p[1]) + 100*Integer.parseInt(v[1]))%R + R)%R;
            //System.out.println("pX without mod: "+ (Integer.parseInt(p[1]) + 100*Integer.parseInt(v[1])));
            //System.out.println("py: "+ py + " px: "+ px);
            finalPositions[px][py]++;
        }

        System.out.println(Arrays.deepToString(finalPositions));
        int res = 1;
        for(int i = 0; i < finalPositions.length; i+=i+1+R/2){
            for(int j = 0; j < finalPositions.length; j+=j+1+C/2){
                int q = countRobots(i, j, finalPositions);
                System.out.println("i: "+i+" j: " +j+": "+q);
                res = res * q;
            }
        }
        System.out.println("safety factor: "+res);
    }

    static int countRobots(int startI, int startJ, int[][] positions){
        int count = 0;
        for(int i = startI; i < startI+R/2; i++){
            for(int j = startJ; j < startJ+C/2; j++){
                count += positions[i][j];
            }
        }
        return count;
    }


}
