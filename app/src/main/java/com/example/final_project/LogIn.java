package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.final_project.MainPage.MainActivity;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    private Button DoneButton;

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        DoneButton = (Button) findViewById(R.id.done_log);
        DoneButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.done_log:
                // Intent intent = AddCrimeActivity.newIntent(MainActivity.this, "title");
                //startActivityForResult(new Intent(LogIn.this, MainPage.class), 0);
                break;
        }
    }
}