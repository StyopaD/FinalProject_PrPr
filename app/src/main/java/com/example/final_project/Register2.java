package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.final_project.MainPage.MainActivity;

public class Register2 extends AppCompatActivity implements View.OnClickListener {
    private Button StartButton;

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        StartButton = (Button) findViewById(R.id.start_reg);
        StartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_reg:
                // Intent intent = AddCrimeActivity.newIntent(MainActivity.this, "title");
                //startActivityForResult(new Intent(Register2.this, Discover.class), 0);
                break;
        }
    }
}