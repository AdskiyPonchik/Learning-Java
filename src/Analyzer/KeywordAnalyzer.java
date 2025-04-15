package Analyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String i : getKeywords()) {
            if (text.contains(i)) return getLabel();
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private final String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
;

class NegativeTextAnalyzer extends KeywordAnalyzer {

    private final String[] negative_smiles = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return negative_smiles;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
};

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int length) {
        this.maxLength = length;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > this.maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
};
