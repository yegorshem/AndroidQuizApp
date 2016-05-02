package net.greenrivertech.yegorshem.androidquizapp;

/**
 * This class represents a quiz question
 *
 * @author Yegor Shemereko
 */
public class Question {

    private String statement;
    private boolean answer;
    private boolean done;

    /**
     * A Question constructor
     *
     * @param statement - the actual question
     * @param answer - true if correct
     * @param done - true if done
     */
    public Question(String statement, boolean answer, boolean done) {
        this.statement = statement;
        this.answer = answer;
        this.done = done;
    }

    /**
     * Custom constructor, making the done param false
     *
     * @param statement
     * @param answer
     */
    public Question(String statement, boolean answer) {
        this(statement, answer, false);
    }

    /**
     * Statement getter
     *
     * @return - returns the quiz question
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Answer getter
     *
     * @return - returns true if answer is true
     */
    public boolean isAnswer() {
        return answer;
    }

    /**
     * Done getter
     *
     * @return - true if done
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Done setter
     *
     * @param done - set to true if done
     */
    public void setDone(boolean done) {
        this.done = done;
    }

}
