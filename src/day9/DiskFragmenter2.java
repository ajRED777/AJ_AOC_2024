package day9;

import java.util.*;

import static Util.TxtFileProcessor.readFileLines;

public class DiskFragmenter2 {
    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day9/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        var arr = input.get(0).toCharArray();
        List<List<Integer>> fileList = new ArrayList<>(); // fileId, fileStart, len
        List<List<Integer>> spaceList = new ArrayList<>(); // start, len
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i%2==0){
                int len = arr[i]-'0';
                fileList.add(List.of(i/2, idx, len));
                System.out.println("File: "+List.of(i/2, idx, len));
                idx+=len;
            }else{
                int len = arr[i]-'0';
                spaceList.add(List.of(idx, len));
                System.out.println("Free: "+List.of(idx, len));
                idx+=len;
            }
        }
        System.out.println("file list: "+fileList);
        System.out.println("space list: "+spaceList);
        for(int f = fileList.size()-1; f>=0; f--){
            int fileId = fileList.get(f).get(0);
            int fileStart = fileList.get(f).get(1);
            int fileLen = fileList.get(f).get(2);
            System.out.println("checking space for file: "+fileList.get(f));
            for(int s = 0; s<spaceList.size(); s++){
                int spaceStart = spaceList.get(s).get(0);
                int spaceLen = spaceList.get(s).get(1);
                if(fileLen<=spaceLen && fileStart>spaceStart){
                    System.out.println("Space found for file: "+fileList.get(s));
                    var movedFile = List.of(fileId, spaceStart, fileLen);
                    var freeSpace = List.of(spaceStart+fileLen, spaceLen-fileLen);
                    fileList.set(f, movedFile);
                    spaceList.set(s, freeSpace);
                    break;
                }
            }

        }

        fileList.sort(Comparator.comparingInt(a -> a.get(1)));
        System.out.println(fileList);
        long sum = 0;
        for(var file:fileList){
            int fIdx = file.get(1);
            while(fIdx < file.get(1)+file.get(2))
                sum+= (long) file.get(0) *fIdx++;
        }
        System.out.println(sum);
    }


    static void appendChar(char c, int count, StringBuilder sb){
        sb.append(String.valueOf(c).repeat(Math.max(0, count)));
    }
}
