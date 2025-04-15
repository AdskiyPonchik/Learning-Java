package Stack_Pali;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PalindromeTest{
    @Test
    void testPalindromes() {
        assertTrue(Palindrome.isPalindrome("Reliefpfeiler"));
        assertTrue(Palindrome.isPalindrome("Lagerregal"));
        assertTrue(Palindrome.isPalindrome("Ein Esel lese nie."));
        assertTrue(Palindrome.isPalindrome("Na, Fakir, Paprika-Fan?"));
        assertTrue(Palindrome.isPalindrome("Eine Horde bedrohe nie!"));
        assertTrue(Palindrome.isPalindrome("Madam"));
        assertTrue(Palindrome.isPalindrome("Marktkram"));
        assertTrue(Palindrome.isPalindrome("Gurken hol ohne Krug!"));
        assertTrue(Palindrome.isPalindrome("O, Streit irritiert so!"));
    }
}
