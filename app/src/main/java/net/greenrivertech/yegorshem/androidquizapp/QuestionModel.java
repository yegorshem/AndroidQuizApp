package net.greenrivertech.yegorshem.androidquizapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Represents a collection of questions
 *
 * @author Yegor Shemereko
 */
public class QuestionModel extends Fragment {

    private int amountDone;
    private int questionCount;
    private int amountCorrect;
    public ArrayList<Question> questions;

    /**
     * QuestionModel constructor, instantiates a few questions
     */
    public QuestionModel() {
        amountDone = 0;
        questionCount = 0;
        amountCorrect = 0;
        questions = new ArrayList<>();

        questions.add(new Question
                ("Question One:\n Humans cannot breath & swallow simultaneously ", true));
        questions.add(new Question
                ("Question Two:\n This question is considered a question.", false));
        questions.add(new Question
                ("Question Three:\n Google was originally called 'Backrub", true));
        questions.add(new Question
                ("Question Four:\n The first webcam watched a coffee pot.", true));
        questions.add(new Question
                ("Question Five:\n All these questions were actually questions.", false));
    }

    /**
     * Compares answer with user input, if correct updates question count
     *
     * @param answer
     * @return
     */
    public boolean checkAnswer(boolean answer) {
        questions.get(questionCount).setDone(true);
        if (questions.get(questionCount).isAnswer() == answer)
            amountCorrect++;

        return questions.get(questionCount).isAnswer() == answer;
    }

    /**
     * Moves to the next question if it exists
     *
     * @return False if there is no next question
     */
    public boolean nextQuestion() {
        if (questions.get(questionCount).isDone())
            amountDone++;

        if (!(amountDone == questions.size())) {
            do {
                if (questionCount == questions.size() - 1)
                    questionCount = 0;
                else
                    questionCount++;
            } while (questions.get(questionCount).isDone());


            return true;
        }

        return false;
    }

    /**
     * Moves to previous question if it exists
     *
     * @return False if there is no previous question
     */
    public boolean prevQuestion() {
        if (questions.get(questionCount).isDone())
            amountDone++;

        if (!(amountDone == questions.size())) {
            do {
                if (questionCount == 0)
                    questionCount = questions.size() - 1;
                else
                    questionCount--;
            } while (questions.get(questionCount).isDone());


            return true;
        }

        return false;
    }

    /**
     * QuestionCount getter
     *
     * @return the current question user is at
     */
    public int getQuestionCount() {
        return questionCount;
    }

    /**
     * AmountCorrect getter
     *
     * @return the amount of question user got correct
     */
    public int getAmountCorrect() {
        return amountCorrect;
    }

    /**
     * Method needed for saving the instance when onPause
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }
}
