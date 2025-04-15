package Analyzer;
import java.awt.*;

public abstract class KeywordAnalyzer implements TextAnalyzer{
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text){
        for(String i: getKeywords()){
            if(text.contains(i))return getLabel();
        }
        return Label.OK;
    };
}

public class SpamAnalyzer extends KeywordAnalyzer{
    private String[] keywords;
    public SpamAnalyzer(String[] keywords){
        this.keywords = keywords;
    }
    @Override
    protected String[] getKeywords(){
        return keywords;
    }
    @Override
    protected Label getLabel(){
        return Label.SPAM;
    }
};
public class NegativeTextAnalyzer extends KeywordAnalyzer{};
public class TooLongTextAnalyzer implements TextAnalyzer{};
Label checkLabels(Text)


public static void main(String[] args) {
    // инициализация анализаторов для проверки в порядке данного набора анализаторов
    String[] spamKeywords = {"spam", "bad"};
    int commentMaxLength = 40;
    TextAnalyzer[] textAnalyzers1 = {
            new SpamAnalyzer(spamKeywords),
            new NegativeTextAnalyzer(),
            new TooLongTextAnalyzer(commentMaxLength)
    };
    TextAnalyzer[] textAnalyzers2 = {
            new SpamAnalyzer(spamKeywords),
            new TooLongTextAnalyzer(commentMaxLength),
            new NegativeTextAnalyzer()
    };
    TextAnalyzer[] textAnalyzers3 = {
            new TooLongTextAnalyzer(commentMaxLength),
            new SpamAnalyzer(spamKeywords),
            new NegativeTextAnalyzer()
    };
    TextAnalyzer[] textAnalyzers4 = {
            new TooLongTextAnalyzer(commentMaxLength),
            new NegativeTextAnalyzer(),
            new SpamAnalyzer(spamKeywords)
    };
    TextAnalyzer[] textAnalyzers5 = {
            new NegativeTextAnalyzer(),
            new SpamAnalyzer(spamKeywords),
            new TooLongTextAnalyzer(commentMaxLength)
    };
    TextAnalyzer[] textAnalyzers6 = {
            new NegativeTextAnalyzer(),
            new TooLongTextAnalyzer(commentMaxLength),
            new SpamAnalyzer(spamKeywords)
    };
    // тестовые комментарии
    String[] tests = new String[8];
    tests[0] = "This comment is so good.";                            // OK
    tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
    tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
    tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
    tests[4] = "This comment is so bad....";                          // SPAM
    tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
    tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
    tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
    TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
            textAnalyzers4, textAnalyzers5, textAnalyzers6};
}