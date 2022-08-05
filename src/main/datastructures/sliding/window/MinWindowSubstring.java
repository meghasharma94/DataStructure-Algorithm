package sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * 76. Minimum Window Substring
 * Hard
 **/
public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindowSubstring min = new MinWindowSubstring();
        System.out.printf("Min Window Substring is %s ", min.minWindow(s, t));
    }

    private String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int counter = 0;
        int begin = 0, end = 0, head = 0;
        int winSize = Integer.MAX_VALUE;

        counter = frequencyMap.size();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) - 1);
                if (frequencyMap.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {

                char k = s.charAt(begin);
                if (frequencyMap.containsKey(k)) {
                    frequencyMap.put(k, frequencyMap.get(k) + 1);
                    if (frequencyMap.get(k) > 0) counter++;
                }

                if (end - begin < winSize) {
                    winSize = end - begin;
                    head = begin;
                }

                begin++;
            }
        }
        if (winSize == Integer.MAX_VALUE) return "";
        return s.substring(head, head + winSize);
    }
}
