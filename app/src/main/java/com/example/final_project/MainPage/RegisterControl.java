package com.example.final_project.MainPage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.final_project.Discover.DiscoverActivity;
import com.example.final_project.R;
import com.example.final_project.Tab.TabLayoutController;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;
import java.util.regex.Pattern;

public class RegisterControl  {


    public RegisterControl(Context context, LinearLayout layout){
        initializeCardRegister(context, layout);
    }
    private void initializeCardRegister(Context context, LinearLayout layout){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                context, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(context).
                inflate(R.layout.layout_bottom_sheet2, layout);
        EditText username = bottomSheetView.findViewById(R.id.user_name);
        EditText email = bottomSheetView.findViewById(R.id.email_reg);
        EditText password = bottomSheetView.findViewById(R.id.password_reg);
        EditText checkPassword = bottomSheetView.findViewById(R.id.password_reg_repeat);
        EditTextRegister usernameBox =new EditTextRegister(username,context, "The username is not correct",1);
        EditTextRegister emailBox =new EditTextRegister(email,context, "The email is not correct",2);
        new EditTextRegister(password,context, "The password must be LowerCase, UpperCase, at least 8 characters and contain a Number",3);
        new EditTextRegister(checkPassword,context, "The passwords don't match",4);
        System.out.println(password.getText());
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        bottomSheetView.findViewById(R.id.signUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DiscoverActivity.class));
                bottomSheetDialog.dismiss();
                ((Activity)context).finish();
/*
                if(emailBox.isValid()&& usernameBox.isValid()){
                    if(password.getText().toString().matches(checkPassword.getText().toString())){
                        context.startActivity(new Intent(context, DiscoverActivity.class));
                        bottomSheetDialog.dismiss();
                        ((Activity)context).finish();
                    }else{
                        checkPassword.setError("The passwords don't match");
                        checkPassword.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake));
                        checkPassword.setTextColor(Color.rgb(255,0,0));
                    }
                }else{
                    Toast.makeText(context, "The requirements are not fulfilled!", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }
}
