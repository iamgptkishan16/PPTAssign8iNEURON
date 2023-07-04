/*QUESTION[8] Given two strings s and goal, return true *if you can swap two letters in* s *so the result is equal to* goal*, otherwise, return* false*.*

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

- For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

**Example 1:**

**Input:** s = "ab", goal = "ba"

**Output:** true

**Explanation:** You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.*/


public class SwappingTwoLetters {
    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";
        boolean canSwap = buddyStrings(s, goal);
        System.out.println(canSwap); // Output: true
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length() < 2) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
                if (count[ch - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        int first = -1;
        int second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }

        return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
    }
}

