package day2;

import java.util.ArrayList;
import java.util.List;

import static Util.CSVProcessor.processCSV;

public class RedNosedReports {
    static int MIN_DIFF = 1;
    static int MAX_DIFF = 3;
    public static void main(String[] args) {
        var lines = processCSV("src/day2/input1.csv");
        var input = convertToListOfArrays(lines);
        System.out.println(lines);
        int safety = 0;
        for(List arr : input){
            safety += isSafe(arr)?1:0;
        }
        System.out.println("safety: " + safety);

        safety = 0;
        for(List arr : input){
            safety += isSafe2(arr)?1:0;
        }
        System.out.println("safety 2: " + safety);


    }

    static boolean isSafe(List<Integer> report){
        int n = report.size();
        boolean increasing = true;
        boolean decreasing = true;
        for(int i=1; i<n; i++){
            if(report.get(i) <0)
                continue;
            if(Math.abs(report.get(i - 1) - report.get(i))>MAX_DIFF ||
                    Math.abs(report.get(i) - report.get(i - 1))<MIN_DIFF)
                return false;
            if (report.get(i) > report.get(i - 1)) {
                decreasing = false;
            } else if (report.get(i) < report.get(i - 1)) {
                increasing = false;
            }
            if (!increasing && !decreasing)
                return false;
        }
        return true;
    }

    static boolean isSafe2(List<Integer> report){
        int n = report.size();
        boolean increasing = true;
        boolean decreasing = true;
        for(int i=1; i<n; i++){
            boolean good = true;
            if(Math.abs(report.get(i - 1) - report.get(i))>MAX_DIFF ||
                    Math.abs(report.get(i) - report.get(i - 1))<MIN_DIFF)
                good = false;
            if (report.get(i) > report.get(i - 1)) {
                decreasing = false;
            } else if (report.get(i) < report.get(i - 1)) {
                increasing = false;
            }
            if (!increasing && !decreasing)
                good = false;
            if(!good){
                var temp = new ArrayList<>(report);
                temp.remove(i);
                var temp2 = new ArrayList<>(report);
                temp2.remove(i-1);
                return isSafe(temp) || isSafe(temp2);
            }
        }
        return true;
    }

    public static List<List<Integer>> convertToListOfArrays(List<String> stringList) {
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            String[] numberStrings = stringList.get(i).split(",");
            var nums = new ArrayList<Integer>();

            for (int j = 0; j < numberStrings.length; j++) {
                nums.add(Integer.parseInt(numberStrings[j]));
            }

            arr.add(nums);
        }

        return arr;
    }
}
