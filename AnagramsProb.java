/*QUESTION[6] Given two strings s and p, return *an array of all the start indices of* p*'s anagrams in* s. You may return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

**Input:** s = "cbaebabacd", p = "abc"

**Output:** [0,6]

**Explanation:**

The substring with start index = 0 is "cba", which is an anagram of "abc".

The substring with start index = 6 is "bac", which is an anagram of "abc".
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsProb {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> indices = findAnagrams(s, p);
        System.out.println(indices); // Output: [0, 6]
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        int pLength = p.length();
        int sLength = s.length();

        if (sLength < pLength) {
            return indices;
        }

        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        for (int i = 0; i < sLength; i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= pLength) {
                sCount[s.charAt(i - pLength) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                indices.add(i - pLength + 1);
            }
        }

        return indices;
    }
}
