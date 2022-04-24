/*
Problem: https://www.hackerrank.com/challenges/maxsubarray/problem
TC: O(n)
SC: O(1)
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        
        if (arr == null || arr.size() == 0) {
            return result;
        }
        int maxSubArray = getMaxSubArray(arr);
        int maxSubsequence = getMaxSubsequence(arr);
        
        result.add(maxSubArray);
        result.add(maxSubsequence);
        return result;
    }
    
    private static int getMaxSubArray(List<Integer> arr) {
        int maxSum = arr.get(0);
        int contSum = arr.get(0);
        
        for (int i = 1; i < arr.size(); ++i) {
            contSum = Math.max(arr.get(i), contSum + arr.get(i));
            maxSum = Math.max(maxSum, contSum);
        }
        return maxSum;
    }
    
    private static int getMaxSubsequence(List<Integer> arr) {
        int max = arr.get(0);
        
        for (int i = 1; i < arr.size(); ++i) {
            if (max + arr.get(i) > max) {
                max = max + arr.get(i);
            }
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            List<Integer> result = Result.maxSubarray(arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
