package day8;

import java.util.*;

import static Util.TxtFileProcessor.readFileLines;

public class ResonantCollinearity {
    static int R = 0;
    static int C = 0;
    static Set<List<Integer>> set = new HashSet<>();
    static HashMap<Character, List<List<Integer>>> map = new HashMap<>();
    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day8/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        R = input.size();
        C = input.get(0).length();
        char[][] arr = new char[R][];
        for (int i = 0; i < R; i++) {
            arr[i] = input.get(i).toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '.')
                    map.computeIfAbsent(arr[i][j], k->new ArrayList<>()).add(List.of(i,j));
            }
        }

        for(char c:map.keySet()){
            var list = map.get(c);
            for(int i=0; i<list.size(); i++){
                for(int j=i+1; j<list.size(); j++){
                    set.add(list.get(i));
                    set.add(list.get(j));
                    var diff = List.of(list.get(j).get(0)-list.get(i).get(0)
                     , list.get(j).get(1)-list.get(i).get(1));
                    var ia = List.of(list.get(i).get(0)-diff.get(0), list.get(i).get(1)-diff.get(1));
                    var ja = List.of(list.get(j).get(0)+diff.get(0), list.get(j).get(1)+diff.get(1));

                    while(isInTheMap(ia.get(0), ia.get(1))){
                        set.add(ia);
                        ia = List.of(ia.get(0)-diff.get(0), ia.get(1)-diff.get(1));
                    }

                    while(isInTheMap(ja.get(0), ja.get(1))){
                        set.add(ja);
                        ja = List.of(ja.get(0)+diff.get(0), ja.get(1)+diff.get(1));
                    }

                }
            }
        }
        System.out.println(set.size());
    }

    static boolean isInTheMap(int i, int j) {
        return i >= 0 && j >= 0 && i < R && j < C;
    }
}
