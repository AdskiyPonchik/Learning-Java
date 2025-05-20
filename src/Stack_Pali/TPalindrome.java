package Stack_Pali;

//import aud.list.Stack;

public class TPalindrome {
    // Test if text is a T-palindrome.
    // The input is guaranteed to include only valid characters, i.e.,
    // those in {'a',...,'z','(',')','*'}. You don't need to check this.
    //
    public static boolean isPalindrome(String text) {
        // TODO: implementation
        Stack<Character> stack = new Stack<>();
        //text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int len = text.length();
        for (int i = 0; i < len / 2; i++) {
            stack.push(text.charAt(i));
        }
        int start = (len % 2 == 0) ? len / 2 : len / 2 + 1;
        for (int i = start; i < len; i++) {
            if (stack.pop() != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTPalindrome(String text) {
        Stack<Integer> charstack = new Stack<>();
        StringBuilder new_text = new StringBuilder(text);
        for (int i = 0; i < new_text.length(); i++) {
            if (new_text.charAt(i) == '(') {
                charstack.push(i);
            } else if (new_text.charAt(i) == ')') {
                int stringstart = charstack.pop();
                if (isPalindrome(new_text.substring(stringstart + 1, i))) {
                    new_text.replace(stringstart, i + 1, "*");
                    i = -1;
                } else return false;
            }
        }
        return isPalindrome(new_text.toString());
    }

    public static void main(String[] args) {
    }
}