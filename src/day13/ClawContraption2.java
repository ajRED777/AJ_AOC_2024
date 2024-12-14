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
    public static void main(String[] args) {
        List<String> input = readFileLines(13, false);
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
        long add = 10000000000000L;
        for (long[] machine : machines) {
            System.out.println("processing: "+ Arrays.toString(machine));
            long cost = getCost2(machine[4] + add, machine[5] + add, machine[0], machine[1], machine[2], machine[3]);
            if (cost > 0) {
                System.out.println("Cost= " +cost);
                res += cost;
            }
        }

        System.out.println("Total cost: " + res);
    }


    //naive attempt at linear equations in a brute force manner->didnt work
    public static long getCost(long targetX, long targetY, long aX, long aY, long bX, long bY) {
        System.out.println("targetX: " + targetX + " targetY: " + targetY);
        System.out.println("aX: " + aX +" aY: "+ aY + " bX: " + bX + "  bY: " + bY);
        //A * 94 + B * 22 = 10000000008400
        //A * 34 + B * 67 = 10000000005400
        //
        //A * aX + B * bX = targetX -> B*bX = targetX- A*aX -> B = (targetX- A*aX)/bX
        //A * aY + B * bY = targetY -> B*bY = targetY- A*aY -> B = (targetY- A*aY)/bY
        for (long A = 0; A <= targetX / aX; A++) {
            //A * aX + B * bX = targetX -> B*bX = targetX- A*aX -> B = (targetX- A*aX)/bX
            long remainingX = targetX - aX * A;// B*bX = targetX- A*aX
            if (remainingX % bX == 0) { //B = (targetY- A*aY)/bY
                long B = remainingX / bX;

                //A * aY + B * bY = targetY
                long currentY = A * aY + B * bY;
                if (currentY == targetY) {
                    return A * 3 + B;
                }

            }
        }
        return -1;
    }

    public static long getCost2(double targetX, double targetY, double aX, double aY, double bX, double bY) {
        //A * 94 + B * 22 = 10000000008400
        //A * 34 + B * 67 = 10000000005400
        //
        //A * aX + B * bX = targetX
        //get A ->  A = (targetX - B*bX)/aX
        //
        //A * aY + B * bY = targetY
        //substitute A  ->  ((targetX - B*bX)/aX) * aY + B * bY = targetY
        //              ->  (-B * bX *aY)/aX + B*bY = targetY - (targetX * aY)/aX
        //              ->  B = aX/(bY*aX - bX*aY) * (targetY*aX - targetX*aY)/aX
        //              ->  B = (ax*targetY - targetX*aY)/(bY*aX - bX*aY)

        long B = (long) ((long)(aX*targetY - targetX*aY)/(aX*bY-bX*aY));
        long A = (long) ((targetX - B*bX)/aX);
        System.out.println("A: " + A + " B: " + B);
        long actualX = (long) (A*aX + B*bX);
        long actualY = (long) (A*aY + B*bY);
        System.out.println("actualX: " + actualX + " actualY: " + actualY);
        if(A>0 && B>0 && actualX==targetX && actualY==targetY){
            return A*3 + B;
        }
        return -1;
    }

}

