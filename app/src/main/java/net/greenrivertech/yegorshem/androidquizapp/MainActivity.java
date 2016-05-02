package net.greenrivertech.yegorshem.androidquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (ImageButton) findViewById(R.id.imageButton);
    }

    public void onButtonClick(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
}
