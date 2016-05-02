package net.greenrivertech.yegorshem.androidquizapp;

public class Question {

    private String statement;
    private boolean answer;
    private boolean done;


    public Question(String statement, boolean answer, boolean done) {
        this.statement = statement;
        this.answer = answer;
        this.done = done;
    }

    public Question(String statement, boolean answer) {
        this(statement, answer, false);
    }


    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
