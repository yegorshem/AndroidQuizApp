package net.greenrivertech.yegorshem.androidquizapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Yegor Shemereko on 4/22/2016.
 */
public class QuestionModel extends Fragment {

    private int amountDone;
    private int questionCount;
    private int amountCorrect;
    public ArrayList<Question> questions;

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


    public boolean checkAnswer(boolean answer) {
        questions.get(questionCount).setDone(true);
        if( questions.get(questionCount).isAnswer() == answer)
            amountCorrect++;

        return questions.get(questionCount).isAnswer() == answer;
    }

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

    public boolean prevQuestion() {
        if (questions.get(questionCount).isDone())
            amountDone++;

        if (!(amountDone == questions.size())) {
            do {
                if (questionCount ==0 )
                    questionCount = questions.size() - 1;
                else
                    questionCount--;
            } while (questions.get(questionCount).isDone());


            return true;
        }

        return false;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public int getAmountCorrect() {
        return amountCorrect;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setRetainInstance(true);
    }
}
