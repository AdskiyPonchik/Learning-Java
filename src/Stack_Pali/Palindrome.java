package Stack_Pali;

public class Palindrome {
    // Test if text is a palindrome.
    // Ignore upper/lower case, white space, and punctuation.
    //
    public static boolean isPalindrome(String text) {
        // TODO: implementation
        Stack <Character> stack = new Stack<>();
        text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int len = text.length();
        for(int i = 0; i < len/2; i++) {
            stack.push(text.charAt(i));
        }
        int start = (len%2==0) ? len/2 : len/2+1;
        for(int i = start; i < len; i++) {
            if(stack.pop() != text.charAt(i)) {return false;}
        }
        return true;
    }
    public static void main(String[] args) {

    }
}

