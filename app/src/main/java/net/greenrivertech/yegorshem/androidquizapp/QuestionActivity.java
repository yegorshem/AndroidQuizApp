package net.greenrivertech.yegorshem.androidquizapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the Question controller
 *
 * @author Yegor Shemereko
 */
public class QuestionActivity extends AppCompatActivity {

    public final static String AMOUNT_CORRECT = "yegorshem.greenrivertech.net.AndroidQuizApp.AMOUNT_CORRECT";
    public final static String FRAGMENT_TAG = "quiz_fragment";
    QuestionModel quiz;

    TextView question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        FragmentManager fragment = getFragmentManager();

        quiz = (QuestionModel) fragment.findFragmentByTag(FRAGMENT_TAG);

        if (quiz == null) {
            quiz = new QuestionModel();
            //if it is a new one we need to add it to the avaliable fragments
            fragment.beginTransaction().add(quiz, FRAGMENT_TAG).commit();
        }

        question = (TextView) findViewById(R.id.question);
        question.setText(quiz.questions.get(quiz.getQuestionCount()).getStatement());


    }

    /**
     * Pops up the toast notifying if correct or not.
     *
     * @param view
     */
    public void onButtonFalse(View view) {
        toaster(false);
    }

    /**
     * Pops up the toast notifying if correct or not.
     *
     * @param view
     */
    public void onButtonTrue(View view) {
        toaster(true);
    }

    /**
     * Compares the user input with actual answer and returns a toast
     *
     * @param answer - the user input
     */
    private void toaster(boolean answer) {
        String toast;

        if (quiz.checkAnswer(answer)) {
            toast = "Correct!";
        } else {
            toast = "Sorry, Try Again";
        }

        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * Changes the current displayed question to the next question
     */
    private void updateQuestion() {
        question.setText(quiz.questions.get(quiz.getQuestionCount()).getStatement());
    }

    /**
     * Moves to next screen
     *
     * @param view
     */
    public void nextQuestion(View view) {
        if (!quiz.nextQuestion()) {
            nextScreen();
        }

        updateQuestion();
    }

    /**
     * Moves to previous question
     *
     * @param view
     */
    public void prevQuestion(View view) {
        if (!quiz.prevQuestion()) {
            nextScreen();
        }

        updateQuestion();
    }

    /**
     * Goes to the final screen if all questions are answered
     */
    private void nextScreen() {
        Intent intent = new Intent(this, FinalScreen.class);
        String sentNumber = "" + quiz.getAmountCorrect();
        intent.putExtra(AMOUNT_CORRECT, sentNumber);
        startActivity(intent);
    }
}
