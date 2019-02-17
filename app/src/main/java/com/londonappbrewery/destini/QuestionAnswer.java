package com.londonappbrewery.destini;

public class QuestionAnswer {
    private int Question;
    private int TopAnswer;
    private int BottomAnswer;
    private int TopNext, BottomNext;
    private boolean isEnd = false;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getQuestion() {
        return Question;
    }

    public void setQuestion(int question) {
        Question = question;
    }

    public int getTopAnswer() {
        return TopAnswer;
    }

    public void setTopAnswer(int topAnswer) {
        TopAnswer = topAnswer;
    }

    public int getBottomAnswer() {
        return BottomAnswer;
    }

    public void setBottomAnswer(int bottomAnswer) {
        BottomAnswer = bottomAnswer;
    }

    public int getTopNext() {
        return TopNext;
    }

    public void setTopNext(int topNext) {
        TopNext = topNext;
    }

    public int getBottomNext() {
        return BottomNext;
    }

    public void setBottomNext(int bottomNext) {
        BottomNext = bottomNext;
    }

    public QuestionAnswer(int question, int t_answer, int b_answer){
        Question = question;
        TopAnswer = t_answer;
        BottomAnswer = b_answer;
    }
    public QuestionAnswer(int question){
        Question = question;
        isEnd = true;
    }
}
