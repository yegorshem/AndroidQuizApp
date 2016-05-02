package net.greenrivertech.yegorshem.androidquizapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


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

    public void onButtonFalse(View view) {
        toaster(false);
    }

    public void onButtonTrue(View view) {
        toaster(true);
    }

    private void toaster(boolean answer) {
        String toast;

        if (quiz.checkAnswer(answer)) {
            toast = "Correct!";
        } else {
            toast = "Sorry, Try Again";
        }

        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        question.setText(quiz.questions.get(quiz.getQuestionCount()).getStatement());
    }

    public void nextQuestion(View view) {
        if (!quiz.nextQuestion()) {
            nextScreen();
        }

        updateQuestion();
    }

    public void prevQuestion(View view) {
        if (!quiz.prevQuestion()) {
            nextScreen();
        }

        updateQuestion();
    }

    private void nextScreen() {
        Intent intent = new Intent(this, FinalScreen.class);
        String sentNumber = "" + quiz.getAmountCorrect();
        intent.putExtra(AMOUNT_CORRECT, sentNumber);
        startActivity(intent);
    }
}
