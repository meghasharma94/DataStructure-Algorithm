package sliding.window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * 438. Find All Anagrams in a String
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * */
public class FindAllAnagram {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";

        FindAllAnagram anagram = new FindAllAnagram();
        System.out.println("Min number of anagram is "+ anagram.findAnagrams(s, t));
    }

    private List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length() > s.length()) return result;

        Map<Character, Integer> map= new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c , map.getOrDefault(c, 0)+1);
        }
        int counter=0;
        int end=0, begin=0;

        counter=map.size();
        while(end < s.length()){
            char c=s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) counter --;
            }
            end++;

            while(counter==0){
                char x=s.charAt(begin);
                if(map.containsKey(x)){
                    map.put(x, map.get(x)+1);
                    if(map.get(x) > 0) counter ++;
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
           }
         }
        return result;
     }



}
