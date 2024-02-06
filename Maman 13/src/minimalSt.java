/**
 * This class define 'minimalSt' function that finds the minimal string combination of two strings
 * @author Or Herzog
 * @version 5/2/2024
 */

public class minimalSt {
    /**
     * Finds the minimal string combination of two strings
     * The minimal string should have characters from both input strings but with the least number of duplicates
     * @param st1 The first string
     * @param st2 The second string
     * @return The minimal string combination of the two strings
     */
    public static String minimalSt(String st1, String st2) {
        // call a private method to find the minimal string using indexes
        return minimalSt(st1, st2, 0, 0);
    }

    private static String minimalSt(String st1, String st2, int x, int y) {
        // if reached to the end of the st1, return the remaining characters from st2
        if (x >= st1.length()) {
            return st2.substring(y);
        }
        // if reached to the end of the st2, return the remaining characters from st1
        if (y >= st2.length()) {
            return st1.substring(x);
        }
        // if the characters at the same positions in both strings are the same, add the character to the combined string and call minimalSt for the next positions
        if (st1.charAt(x) == st2.charAt(y)) {
            return st1.charAt(x) + minimalSt(st1, st2, x + 1, y + 1);
        } else {
            // if the characters are different, there are two possibilities - with the character from the st1 string or with the character from the st2

            // add the character from st1 to the string result and continue with the next position in st1
            String withX = st1.charAt(x) + minimalSt(st1, st2, x + 1, y);

            // add the character from st2 to the string result and continue with the next position in st2
            String withY = st2.charAt(y) + minimalSt(st1, st2, x, y + 1);

            // return the shorter of the two possibilities
            if (withX.length() < withY.length()) {
                return withX;
            } else {
                return withY;
            }
        }
    }
}
