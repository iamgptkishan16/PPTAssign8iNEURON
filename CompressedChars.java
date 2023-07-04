/*QUESTION[5] Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of **consecutive repeating characters** in chars:

- If the group's length is 1, append the character to s.
- Otherwise, append the character followed by the group's length.

The compressed string s **should not be returned separately**, but instead, be stored **in the input character array chars**. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done **modifying the input array,** return *the new length of the array*.

You must write an algorithm that uses only constant extra space.

**Example 1:**

**Input:** chars = ["a","a","b","b","c","c","c"]

**Output:** Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

**Explanation:**

The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".*/
import java.util.Arrays;
public class CompressedChars {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compress(chars);
        System.out.println(newLength); // Output: 6
        System.out.println(Arrays.toString(chars)); // Output: [a, 2, b, 2, c, 3]
    }

    public static int compress(char[] chars) {
        int anchor = 0;
        int write = 0;

        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    int count = read - anchor + 1;
                    if (count >= 10) {
                        char[] countChars = String.valueOf(count).toCharArray();
                        for (char c : countChars) {
                            chars[write++] = c;
                        }
                    } else {
                        chars[write++] = (char) ('0' + count);
                    }
                }
                anchor = read + 1;
            }
        }

        return write;
    }
}
