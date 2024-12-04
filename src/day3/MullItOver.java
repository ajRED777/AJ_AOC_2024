package day3;

import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class MullItOver {
    public static void main(String[] args) {
        List<String> input = readFileLines("src/day3/input1.txt");
        System.out.println(input);

        StringBuilder s = new StringBuilder();
        for(String l:input)
            s.append(l);
        String line = s.toString();
        //String line = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        //String line = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        System.out.println("Final result without status::: " +compute(line));
        System.out.println("Final result with status::: " +computeWithStatus(line));

    }

    private static long compute(String line) {
        int i = 0;
        long res = 0;
        while(i+4 < line.length()) {
            while (i< line.length() && !line.startsWith("mul(", i))
                i++;
            i+=4;
            var num1 = getNumber(i, line);
            i+=num1.length();
            System.out.println("num1 found "+num1);
            if(i<line.length() && line.charAt(i)!=',')
                continue;
            i++;
            var num2 = getNumber(i, line);
            System.out.println("num2 found "+num2);
            i+=num2.length();
            if(i< line.length()&& line.charAt(i) == ')' && !num1.isBlank() && !num2.isBlank()){
                res += (long) Integer.parseInt(num1) * Integer.parseInt(num2);
                System.out.println("res found "+res);
            }

        }

        System.out.println(res);
        return res;
    }

    static long computeWithStatus(String line) {
        long res = 0;
        int i = 0;
        int start = 0;

        int e = line.indexOf("don't()");
        if (e >= 0 && (line.indexOf("do()") < 0 || e < line.indexOf("do()"))) {
            res += compute(line.substring(0, e));
            line = line.substring(e + 7);
        }

        while (i + 4 < line.length()) {
            start = line.indexOf("do()");
            if (start == -1) break;

            System.out.println("start found at: " + start);

            int end = line.indexOf("don't()", start);
            System.out.println("end found at: " + end);

            if (end == -1) {
                end = line.length();
            }

            res += compute(line.substring(start + 4, end));
            System.out.println("res found for substring: " + res);

            if (end + 7 < line.length()) {
                line = line.substring(end + 7);
            } else {
                break;
            }
        }

        System.out.println("computed with status: " + res);
        return res;
    }


    static String getNumber(Integer i, String line){
        StringBuilder sb = new StringBuilder();
        while(i<line.length() && line.charAt(i)>='0' && line.charAt(i)<='9'){
            sb.append(line.charAt(i));
            i++;
        }

        return sb.toString();
    }
}
