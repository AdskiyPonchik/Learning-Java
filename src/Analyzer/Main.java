package Analyzer;

public class Main {
    public static Label checkLabels(TextAnalyzer[] analyzers, String text){
        for(TextAnalyzer i: analyzers){
            Label result = i.processText(text);
            if(result!=Label.OK) return result;
        }
        return Label.OK;
    }
}