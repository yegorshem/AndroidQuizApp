package net.greenrivertech.yegorshem.androidquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalScreen extends AppCompatActivity {

    TextView amountCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        Intent intent = getIntent();
        String sentNumber = intent.getStringExtra(QuestionActivity.AMOUNT_CORRECT);

        amountCorrect = (TextView) findViewById(R.id.textView2);

        amountCorrect.setText(sentNumber);
    }
}
