package br.com.fabex.algorithms.palindrome;

public class Main {

    private boolean checkWordPalindromeByString(String word) {
        if (null == word || word.length() == 0) {
            return false;
        }
        int length = word.length() - 1;
        int middle = length / 2;
        int start = 0;
        while (start <= middle) {
            if (word.charAt(start++) != word.charAt(length--)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWordPalindromeByArrayChar(char[] word) {
        if (null == word || word.length == 0) {
            return false;
        }
        int length = word.length - 1;
        int middle = length / 2;
        int start = 0;
        while (start <= middle) {
            if (word[start++] != word[length--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        //Test checkWordPalindromeByString
        System.out.println("xbba = " + main.checkWordPalindromeByString("xbba"));
        System.out.println("abba = " + main.checkWordPalindromeByString("abba"));
        System.out.println("ababa = " + main.checkWordPalindromeByString("ababa"));
        System.out.println("xbx = " + main.checkWordPalindromeByString("xbx"));
        System.out.println("xxx = " + main.checkWordPalindromeByString("xxx"));
        System.out.println("xbxx = " + main.checkWordPalindromeByString("xbxx"));
        System.out.println("x = " + main.checkWordPalindromeByString("x"));
        System.out.println("(empty) = " + main.checkWordPalindromeByString(""));
        System.out.println("(null) = " + main.checkWordPalindromeByString(null));

        //Test checkWordPalindromeByArrayChar
        System.out.println("lollipop = " + main.checkWordPalindromeByArrayChar("lollipop".toCharArray()));
        System.out.println("xbba = " + main.checkWordPalindromeByArrayChar("xbba".toCharArray()));
        System.out.println("abba = " + main.checkWordPalindromeByArrayChar("abba".toCharArray()));
        System.out.println("ababa = " + main.checkWordPalindromeByArrayChar("ababa".toCharArray()));
        System.out.println("xbx = " + main.checkWordPalindromeByArrayChar("xbx".toCharArray()));
        System.out.println("xxx = " + main.checkWordPalindromeByArrayChar("xxx".toCharArray()));
        System.out.println("xbxx = " + main.checkWordPalindromeByArrayChar("xbxx".toCharArray()));
        System.out.println("x = " + main.checkWordPalindromeByArrayChar("x".toCharArray()));
        System.out.println("(empty) = " + main.checkWordPalindromeByArrayChar("".toCharArray()));
        System.out.println("(null) = " + main.checkWordPalindromeByString(null));

    }
}
