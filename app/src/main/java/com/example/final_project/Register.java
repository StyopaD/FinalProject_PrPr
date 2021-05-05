package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.final_project.MainPage.MainActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private Button NextButton;
    private EditText emailText;
    private EditText passwordText;
    private String info;
    private String info2;

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailText = (EditText)findViewById(R.id.email_reg);
        passwordText = (EditText)findViewById(R.id.password_reg);
        NextButton = (Button) findViewById(R.id.next_reg);
        NextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_reg:
                // Intent intent = AddCrimeActivity.newIntent(MainActivity.this, "title");
                Intent data = new Intent();
                info = String.valueOf(emailText.getText());
                data.putExtra("mail", info);
                info2 = String.valueOf(passwordText.getText());
                data.putExtra("password", info2);
                setResult(RESULT_OK, data);
               // myUsers users = myUsers.get(this);
               // users.addUser(info, info2);
                finish();
                startActivityForResult(new Intent(Register.this, Register2.class), 0);
                break;
        }
    }
}