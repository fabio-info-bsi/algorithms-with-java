package br.com.fabex.algorithms.palindrome;

public class Main {

    private boolean checkWordPalindrome(String word) {
        if (null == word || word.length() == 0) {
            return false;
        }
        return this.checkWordPalindrome(word.toCharArray());
    }

    private boolean checkWordPalindrome(char[] word) {
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

    private boolean checkWordPalindromeRecursive(char[] word) {
        if (null == word) {
            return true;
        }
        return checkWordPalindromeRecursive(word, 0);
    }

    private boolean checkWordPalindromeRecursive(char[] word, int index) {
        int middle = word.length / 2;
        if (word.length <= 1 || index == middle) {
            return true;
        }
        return word[index] == word[word.length - index - 1] ? checkWordPalindromeRecursive(word, ++index) : false;
    }

    public static void main(String[] args) {
        Main main = new Main();

        //Test Recursive
        System.out.println("xbba = " + main.checkWordPalindromeRecursive("xbba".toCharArray()));
        System.out.println("ababa = " + main.checkWordPalindromeRecursive("ababa".toCharArray()));
        System.out.println(" = " + main.checkWordPalindromeRecursive("".toCharArray()));
        System.out.println("a = " + main.checkWordPalindromeRecursive("a".toCharArray()));
        System.out.println("aaAAbAAaa = " + main.checkWordPalindromeRecursive("aaAAbAAaa".toCharArray()));
        System.out.println("aaAAbzAAaa = " + main.checkWordPalindromeRecursive("aaAAbzAAaa".toCharArray()));

        //Test checkWordPalindrome By String
        System.out.println("xbba = " + main.checkWordPalindrome("xbba"));
        System.out.println("abba = " + main.checkWordPalindrome("abba"));
        System.out.println("ababa = " + main.checkWordPalindrome("ababa"));
        System.out.println("xbx = " + main.checkWordPalindrome("xbx"));
        System.out.println("xxx = " + main.checkWordPalindrome("xxx"));
        System.out.println("xbxx = " + main.checkWordPalindrome("xbxx"));
        System.out.println("x = " + main.checkWordPalindrome("x"));
        System.out.println("(empty) = " + main.checkWordPalindrome(""));
        System.out.println("(null) = " + main.checkWordPalindrome((String) null));

        //Test checkWordPalindrome
        System.out.println("lollipop = " + main.checkWordPalindrome("lollipop".toCharArray()));
        System.out.println("xbba = " + main.checkWordPalindrome("xbba".toCharArray()));
        System.out.println("abba = " + main.checkWordPalindrome("abba".toCharArray()));
        System.out.println("ababa = " + main.checkWordPalindrome("ababa".toCharArray()));
        System.out.println("xbx = " + main.checkWordPalindrome("xbx".toCharArray()));
        System.out.println("xxx = " + main.checkWordPalindrome("xxx".toCharArray()));
        System.out.println("xbxx = " + main.checkWordPalindrome("xbxx".toCharArray()));
        System.out.println("x = " + main.checkWordPalindrome("x".toCharArray()));
        System.out.println("(empty) = " + main.checkWordPalindrome("".toCharArray()));
        System.out.println("(null) = " + main.checkWordPalindrome((char[]) null));

    }
}
