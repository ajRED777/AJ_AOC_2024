package day9;

import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class DiskFragmenter {
    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day9/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        var arr = input.get(0).toCharArray();
        int i = 0;
        int j = arr.length - 1;
        long checkSum = 0;
        int filePosition = 0;
        int jCount = Integer.parseInt(String.valueOf(arr[j]));
        while (i <= j) {
            if (i % 2 == 0) {

                long fileId = i / 2;
                int fileCount = i==j?jCount:Integer.parseInt(String.valueOf(arr[i]));
                while (fileCount > 0) {
                    System.out.println("i:" + i/2 + " * "+ filePosition);
                    checkSum += fileId*filePosition;
                    fileCount--;
                    filePosition++;
                }
            }else{
                int freeSpace = Integer.parseInt(String.valueOf(arr[i]));

                while (i<j && freeSpace > 0 && jCount>0) {
                    System.out.println("j:" + j/2 + " * "+ filePosition);
                    checkSum += (long) (j / 2) *filePosition;
                    freeSpace--;jCount--;
                    filePosition++;
                    if(jCount==0){
                        j-=2;
                        jCount = Integer.parseInt(String.valueOf(arr[j]));
                    }
                }

            }
            i++;
        }


        System.out.println("checksum:"+checkSum);
    }
}
