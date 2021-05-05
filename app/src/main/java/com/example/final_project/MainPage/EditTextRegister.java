package com.example.final_project.MainPage;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.example.final_project.R;

import java.util.regex.Pattern;

public class EditTextRegister implements TextWatcher {

    private final EditText text;
    private boolean valid;
    private long last_text_edit;
    private final int pos;
    private final long delay = 1500;
    private final Context context;
    private final String error;
    private static String password;



    public EditTextRegister(EditText text, Context context, String string, int pos){
        this.text = text;
        this.context = context;
        this.pos = pos;
        error = string;

        text.addTextChangedListener(this);
    }

    private Animation shakeError(){
        return AnimationUtils.loadAnimation(context, R.anim.shake);
    }

    private final Runnable input_finish_checker = new Runnable() {
        public void run() {
            if (System.currentTimeMillis() > (last_text_edit + delay - 500)) {
                if(!valid){
                    text.setTextColor(Color.rgb(255,0,0));
                    text.startAnimation(shakeError());
                    text.setError(error);
                }else{

                    text.setTextColor(Color.rgb(0,255,0));
                    if(pos==3)
                        password = text.getText().toString();

                }
            }

        }
    };

    public boolean isValid() {
        return valid;
    }

    public EditText getEText() {
        return text;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        text.setTextColor(Color.rgb(255,255,255));
        if(!text.getText().toString().matches("")){
            last_text_edit = System.currentTimeMillis();
            new Handler().postDelayed(input_finish_checker,delay);
            valid = isValid(text.getText().toString());
        }
    }

    private boolean isValid(String string)
    {
        switch (pos){
            case 1:
                return !string.matches("");
            case 2:
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";

                Pattern pat = Pattern.compile(emailRegex);
                if (string == null)
                    return false;
                return pat.matcher(string).matches();
            case 3:
                return string.length() > 7 && checkString(string);
            case 4:
                return string.equals(password);
        }
        return false;
    }

    private static boolean checkString(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag){
                /*if(checkPass == null){
                   return true;
                }else{
                    if(str.equals(checkPass)){
                        return true;
                    }
                }*/
                return true;

            }
        }
        return false;
    }
}
